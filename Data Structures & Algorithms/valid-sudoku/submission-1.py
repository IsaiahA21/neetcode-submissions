# Doing it in 1-pass through
# row check: hashmap with 9 arrays of set, return false
# col check: hashmap with 9 arrays of set, return false
# 9 array cause there 9 rows and cause there is 9 cols
# square check: hashmap with 9 arrays(subboxes) of set. set((row //3, col //3)), return false.
# subBoxSet{
#   (0, 0): {}
# }
# why // 3. because there is 9 rows and 9 cols. // 3 gives us the coordinate of the sub-box
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowSetArr = [set() for _ in range(9)]
        colSetArr = [set() for _ in range(9)]
        subBoxSet= defaultdict(set)

        for row in range(9):
            for col in range(9):
                if board[row][col] != ".": 
                    if (board[row][col] in rowSetArr[row]
                        or board[row][col] in colSetArr[col] 
                        or board[row][col] in subBoxSet[(row // 3, col // 3)]):
                        return False
                    
                    rowSetArr[row].add(board[row][col])
                    colSetArr[col].add(board[row][col])
                    subBoxSet[(row//3, col//3)].add(board[row][col])
        
        return True