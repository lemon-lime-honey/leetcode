SELECT name AS Employee
FROM Employee as a
WHERE a.salary > (
    SELECT salary
    FROM Employee as b
    WHERE b.id = a.managerId
);