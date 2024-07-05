-- View index information on SQL Server

SELECT * FROM sys.indexes;

SELECT  sys.objects.name AS [table name],
        sys.indexes.name AS [index name],
        sys.objects.object_id AS [object id],
        sys.indexes.type_desc AS [index type],
        CASE (sys.indexes.is_primary_key)
            WHEN 0 THEN ''
            WHEN 1 THEN 'Primary Key'
        END AS [primary key],
        CASE (sys.indexes.is_unique_constraint)
            WHEN 0 THEN ''
            WHEN 1 THEN 'Unique Constraint'
        END AS [unique constraint]
FROM sys.objects JOIN sys.indexes ON sys.objects.object_id = sys.indexes.object_id
WHERE sys.objects.type_desc = 'USER_TABLE';

-- View index usage statistics
SELECT * FROM sys.dm_db_index_usage_stats;

SELECT  OBJECT_NAME(s.object_id) AS [table name],
        i.name AS [index name],
        s.user_seeks,
        s.user_scans,
        s.user_lookups,
        s.user_updates,
        s.last_user_seek,
        s.last_user_scan
FROM sys.dm_db_index_usage_stats AS s
    JOIN sys.indexes AS i ON i.object_id = s.object_id;