SELECT firstName, lastName, city, state
FROM Person
LEFT OUTER JOIN Address
ON Address.personId = Person.personId;