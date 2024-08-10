SELECT
    a.employee_id,
    a.name,
    COUNT(b.reports_to) AS 'reports_count',
    ROUND(AVG(b.age)) AS 'average_age'
FROM Employees AS a
INNER JOIN Employees AS b
    ON a.employee_id = b.reports_to
GROUP BY a.employee_id
ORDER BY a.employee_id;