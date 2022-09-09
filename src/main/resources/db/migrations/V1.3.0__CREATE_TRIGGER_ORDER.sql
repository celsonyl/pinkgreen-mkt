
CREATE FUNCTION insert_orders_log()
    RETURNS TRIGGER
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    SET TIMEZONE TO 'America/Sao_Paulo';

    INSERT INTO orders_log(order_id, status, updated_at, createdat)
    VALUES (NEW.id, 'ORDER_CREATED',NOW() ,NOW());

    RETURN NEW;
END;
$$;
alter function insert_orders_log() owner to local;


CREATE TRIGGER INSERT_ORDERS_LOG
    AFTER INSERT
    ON orders
    FOR EACH ROW
EXECUTE PROCEDURE insert_orders_log();


