SELECT CONCAT('/home/grep/src/', B.BOARD_ID, '/', CONCAT(F.FILE_ID, F.FILE_NAME, F.FILE_EXT))
FROM USED_GOODS_BOARD AS B, USED_GOODS_FILE AS F
WHERE B.BOARD_ID = F.BOARD_ID
    AND B.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY F.FILE_ID DESC;