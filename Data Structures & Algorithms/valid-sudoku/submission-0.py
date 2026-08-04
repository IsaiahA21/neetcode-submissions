# pattern we fast lookup - map
# we need to know if we have seen tis number before either in the row, col or 3x3
# Check all rows
#   - hashset of the numbers we seen
#   - if num exist return false
# check all cols
# check 3x3

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # check all rows

        for row in range(9):
            validRowSet = set()
            for col in range(9):
                if board[row][col] != '.':
                    if board[row][col] in validRowSet:
                        print("check rows",row, col)
                        return False
                    validRowSet.add(board[row][col])

        # check all cols
        for col in range(9):
            validColSet = set()
            for row in range(9):
                if board[row][col] != '.':
                    if board[row][col] in validColSet:
                        print('check cols',row, col)
                        return False
                    validColSet.add(board[row][col])
        
        #check 3x3s
        startcor = [(0,0), (0,3), (0,6), (3,0), (3,3), (3,6), (6,0), (6,3), (6,6)]
        for x, y in startcor:
            validSquareSet = set()
            for row in range (x,x+3):
                for col in range (y, y+3):
                    if board[row][col] != '.':
                        if board[row][col] in validSquareSet:
                            print('3x3',row, col)
                            return False
                        validSquareSet.add(board[row][col])



        return True
        