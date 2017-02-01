'''
  Astar is the most popular and optimum way to find path between two tiles, or two nodes in a graph/maze
  Please look at maze1.txt and maze2.txt
  All characters are in hexadecimal format, and each character represents a tile in the maze.
  Each character also represents directions.
  For example, 'B' in binary is '1011'
  1 is for True, 0 is for false
  First index - Possibility to move up (True in the above case)
  Second index - Possibility to move left (False)
  Third index - Possibility to move right (True)
  Fourth index - Possibility to move down (True)

  Similarly, 'A' in binary is 1010, meaning, there is possibility to move only 'up' and 'right' from the current tile
'''



import heapq


class PriorityQueue:
    '''Implements a Priority Queue based on a min heap'''
    def __init__(self):
        self.elements = []

    def empty(self):
        return len(self.elements) == 0

    def put(self, item, priority):
        heapq.heappush(self.elements, (priority, item))

    def get(self):
        return heapq.heappop(self.elements)[1]


class Astar:

    def __init__(self, file):
        self.file = file #Input file to read the Maze from
        self.maze = []
        self.start = None
        self.goal = None
        self.read_file_and_create_maze()
        self.compute_start_and_goal()

    def read_file_and_create_maze(self):
        '''Reads the file in hexadecimal format, converts it into binary and stores it in a list'''
        for line in open(self.file):
            self.maze.append(list(line.strip().replace(' ', '')))
        for row in self.maze:
            for j in range(len(row)):
                row[j] = self.hex_to_bin(row[j])

    def compute_start_and_goal(self):
        '''Finds and stores the Starting and ending tile in the maze'''
        for i in range(len(self.maze)):
            if self.start is None and self.maze[i][0][1] == '1':
                self.start = (i, 0)
                self.maze[i][0] = self.maze[i][0][:1] + '0' + self.maze[i][0][2:]
            if self.goal is None and self.maze[i][len(self.maze[i]) - 1][2] == '1':
                self.goal = (i, len(self.maze[i]) - 1)
                self.maze[i][len(self.maze[i]) - 1] = self.maze[i][len(self.maze[i]) - 1][:2] \
                                                      + '0' + self.maze[i][len(self.maze[i]) - 1][3:]

    def manhattan_distance(self, a, b):
        '''Calculates distance between two tiles. We use this to select only those neighbouring tiles that
        are nearest to the goal(heuristic function)'''
        (x1, y1) = a
        (x2, y2) = b
        return abs(x1 - x2) + abs(y1 - y2)

    def calculate_path(self):
        '''Calculates the path from start to end, and stores it in self.path'''
        queue = PriorityQueue()
        queue.put(self.start, 0) #Initially the queue consists the starting tile
        came_from = {} #This stores 'where did the current tile come from(path)?'
        cost_so_far = {} #This stores the minimum cost of every tile we discover with this algorithm
        came_from[self.start] = None
        cost_so_far[self.start] = 0

        while not queue.empty():
            current = queue.get()

            if current == self.goal:
                break

            for neighbour in self.get_neighbours(current, self.maze[current[0]][current[1]]):
                new_cost = cost_so_far[current] + 1
                if neighbour not in cost_so_far or new_cost < cost_so_far[neighbour]:
                    cost_so_far[neighbour] = new_cost
                    priority = new_cost + self.manhattan_distance(self.goal, neighbour)
                    queue.put(neighbour, priority)
                    came_from[neighbour] = current

        self.path = []

        temp = self.goal
        while not temp is None:
            self.path.append(temp)
            temp = came_from[temp]

        self.path = list(reversed(self.path))


    def hex_to_bin(self, hex):
        '''Converts hexadecimal character to binary string, justifies the length to 4 by padding with zeroes'''
        return bin(int(hex, 16))[2:].rjust(4, "0")


    def get_neighbours(self, current, str):
        '''Returns possible neighbours for current tile. Possibility defined by str(Strings such as 1111, 1011 etc.)'''
        neighbours = []
        if str[0] == '1':
            neighbours.append((-1 + current[0], 0 + current[1]))
        if str[1] == '1':
            neighbours.append((0 + current[0], -1 + current[1]))
        if str[2] == '1':
            neighbours.append((0 + current[0], 1 + current[1]))
        if str[3] == '1':
            neighbours.append((1 + current[0], 0 + current[1]))

        return neighbours

    def print_maze(self):
        '''
        Prints the final maze
        S - Starting tile
        G - Goal tile
        0 - Tile not included in path to the goal
        1 - Tile included in path
        '''
        for i in range(len(self.maze)):
            for j in range(len(self.maze[i])):
                if (i,j) in self.path:
                    if (i,j) == self.start:
                        print("S\t", end='')
                    elif (i,j) == self.goal:
                        print("G\t", end='')
                    else:
                        print("1\t", end='')
                else:
                    print("0\t", end='')
            print()
        print()


a = Astar("maze.txt")
a.calculate_path()
a.print_maze() #Printing the final maze

a = Astar("maze2.txt")
a.calculate_path()
a.print_maze()



