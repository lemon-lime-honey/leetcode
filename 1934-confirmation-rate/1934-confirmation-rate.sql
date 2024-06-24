SELECT
    Signups.user_id,
    ROUND(
        COUNT(
            CASE WHEN Confirmations.action='confirmed'
            THEN 1
            ELSE NULL END
            )/COUNT(*), 2
        ) AS 'confirmation_rate'
FROM Signups
LEFT OUTER JOIN Confirmations
ON Signups.user_id = Confirmations.user_id
GROUP BY user_id;