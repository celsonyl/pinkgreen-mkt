create function INSERT_ORDERS_LOG()
    RETURNS trigger
    LANGUAGE PLPGSQL
AS
$$
begin
    set TIMEZONE TO 'America/Sao_Paulo';

    if (TG_OP = 'INSERT') then
        insert into ORDERS_LOG(ORDER_ID, STATUS, UPDATED_AT, CREATED_AT)
        values (NEW.ID, NEW.STATUS, NOW(), NOW());

        return new;
    elsif (TG_OP = 'UPDATE') then
        insert into ORDERS_LOG(ORDER_ID, STATUS, UPDATED_AT, CREATED_AT)
        values (OLD.ID, NEW.STATUS, NEW.UPDATED_AT, NEW.CREATED_AT);

        return new;
    end if;
    return null;
end;
$$;
alter function INSERT_ORDERS_LOG() owner to local;


create trigger INSERT_ORDERS_LOG
    after insert or update
    on ORDERS
    for each row
EXECUTE procedure INSERT_ORDERS_LOG();


