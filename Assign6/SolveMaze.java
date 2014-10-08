
public class SolveMaze {
	
public static void main(String[] args){
	Maze Maze = new Maze();

	Maze.setDirection(Maze.EAST);
			
		while(Maze.goalIsNotReached()==true){ //Maze.getDirection()
				
			if(Maze.getDirection() == Maze.EAST && Maze.wallPresent(Maze.EAST)==true){
				Maze.setDirection(Maze.SOUTH);
				}else if(Maze.getDirection() == Maze.EAST && Maze.wallPresent(Maze.EAST) == false){
					Maze.moveEast();
					if(Maze.getDirection() == Maze.EAST && Maze.wallPresent(Maze.NORTH)==false){
						Maze.setDirection(Maze.NORTH);
					}
			}
			if(Maze.getDirection() == Maze.SOUTH && Maze.wallPresent(Maze.SOUTH)==true){
				Maze.setDirection(Maze.WEST);
			}else if(Maze.getDirection() == Maze.SOUTH && Maze.wallPresent(Maze.SOUTH) == false){
					Maze.moveSouth();
					if(Maze.getDirection() == Maze.SOUTH && Maze.wallPresent(Maze.EAST)==false){
						Maze.setDirection(Maze.EAST);
					}
			}
			if(Maze.getDirection() == Maze.WEST && Maze.wallPresent(Maze.WEST)==true){
				Maze.setDirection(Maze.NORTH);
			}else if(Maze.getDirection() == Maze.WEST && Maze.wallPresent(Maze.WEST) == false){
					Maze.moveWest();
					if(Maze.getDirection() == Maze.WEST && Maze.wallPresent(Maze.SOUTH)==false){
						Maze.setDirection(Maze.SOUTH);
					}
			}
			if(Maze.getDirection() == Maze.NORTH && Maze.wallPresent(Maze.NORTH)==true){
				Maze.setDirection(Maze.EAST);
			}else if(Maze.getDirection() == Maze.NORTH && Maze.wallPresent(Maze.NORTH) == false){
					Maze.moveNorth();
					if(Maze.getDirection() == Maze.NORTH && Maze.wallPresent(Maze.WEST)==false){
						Maze.setDirection(Maze.WEST);
					}
			}
		}
	}
}