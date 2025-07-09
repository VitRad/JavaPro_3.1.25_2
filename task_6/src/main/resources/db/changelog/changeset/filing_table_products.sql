DO $$
DECLARE
    p_type TEXT;
BEGIN

    FOR i IN 1..2 LOOP
        FOR j IN 1..5 LOOP
                IF i % 2 = 0 THEN
                p_type := 'ACCOUNT';
                ELSE
                p_type := 'CARD';
                END IF;
            INSERT INTO products (account, balance, product_type, user_id)
            VALUES ('40817810000111222' || i+j, 100 + i+j, p_type, j);
        END LOOP;
    END LOOP;

END $$;