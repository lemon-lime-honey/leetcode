SELECT a.id
FROM Weather AS a, Weather As b
WHERE a.temperature > b.temperature AND
      DATEDIFF(a.recordDate, b.recordDate) = 1;