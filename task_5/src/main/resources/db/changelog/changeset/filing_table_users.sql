DO $$
BEGIN
    FOR i IN 1..5 LOOP
        INSERT INTO users (username)
        VALUES ('test-user-' || substr(md5(random()::text), 0, 100));
    END LOOP;
END $$;