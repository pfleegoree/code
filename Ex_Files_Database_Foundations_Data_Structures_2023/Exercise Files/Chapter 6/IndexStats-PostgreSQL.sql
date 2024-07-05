-- View index information on PostgreSQL

SELECT * FROM pg_indexes;

SELECT * FROM pg_indexes
WHERE tablename = 'customers';

SELECT * FROM pg_indexes
WHERE schemaname = 'public';

-- View index usage statistics
SELECT * FROM pg_stat_user_indexes;