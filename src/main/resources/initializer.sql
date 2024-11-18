CREATE DATABASE IF NOT EXISTS dev_wrm_db;
CREATE DATABASE IF NOT EXISTS prod_wrm_db;
CREATE DATABASE IF NOT EXISTS uat_wrm_db;
CREATE DATABASE IF NOT EXISTS sit_wrm_db;


create
    definer = root@`%` function calc_average_waiting_time(id bigint) returns double reads sql data
BEGIN
    DECLARE avg_waiting_time DOUBLE;

    SELECT AVG(TIMESTAMPDIFF(MINUTE, v.arrival_time, v.start_time))
    INTO avg_waiting_time
    FROM visits v
    WHERE v.waiting_list_id = id
      AND v.start_time IS NOT NULL
      AND v.arrival_time IS NOT NULL;

    RETURN avg_waiting_time;
END;


create
    definer = root@`%` function calc_satisfaction_rate(id bigint) returns double reads sql data
BEGIN
    DECLARE satisfaction_rate DOUBLE;

    SELECT (SUM(IF(v.visit_status = 'COMPLETED' , 1 , 0)) / COUNT(*)) * 100
    INTO satisfaction_rate
    FROM visits v
    WHERE v.waiting_list_id = id;
    RETURN satisfaction_rate;
END;

