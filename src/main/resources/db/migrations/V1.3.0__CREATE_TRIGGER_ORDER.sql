CREATE FUNCTION insert_orders_log()
    RETURNS TRIGGER
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    SET TIMEZONE TO 'America/Sao_Paulo';

    IF (TG_OP = 'INSERT') THEN
        INSERT INTO orders_log(order_id, status, updated_at, createdat)
        VALUES (NEW.id, NEW.status, NOW(), NOW());

        RETURN NEW;
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO orders_log(order_id, status, updated_at, createdat)
        VALUES (OLD.id, NEW.status, NOW(), NOW());

        RETURN NEW;
    END IF;
    RETURN NULL;
END;
$$;
alter function insert_orders_log() owner to local;


CREATE TRIGGER INSERT_ORDERS_LOG
    AFTER INSERT OR UPDATE
    ON orders
    FOR EACH ROW
EXECUTE PROCEDURE insert_orders_log();


