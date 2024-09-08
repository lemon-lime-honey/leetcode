SELECT a.firstName, a.lastName, b.city, b.state
FROM person AS a
LEFT OUTER JOIN address AS b
    ON a.personId = b.personId;