SELECT USER_ID, NICKNAME,
    CONCAT_WS(' ', CITY, STREET_ADDRESS1, STREET_ADDRESS2) AS 전체주소,
    CONCAT_WS('-', SUBSTR(TLNO, 1, 3), SUBSTR(TLNO, 4, 4), SUBSTR(TLNO, 8, 4)) AS 전화번호
FROM USED_GOODS_BOARD, USED_GOODS_USER
WHERE WRITER_ID = USER_ID AND WRITER_ID IN (SELECT USER_ID
                                            FROM USED_GOODS_BOARD, USED_GOODS_USER
                                            WHERE WRITER_ID = USER_ID
                                            GROUP BY USER_ID
                                            HAVING 3 <= COUNT(*))
GROUP BY USER_ID
ORDER BY WRITER_ID DESC;