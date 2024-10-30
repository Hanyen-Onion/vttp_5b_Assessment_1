package vttp.batch5.sdf.task02;

public class Main {

	public static void main(String[] args) throws Exception {

		if (args.length <= 0) {
			System.err.println("Missing TTT file");
			System.exit(1);
		}

		//initialise
		TicTacToe ttt = new TicTacToe(args[0]);
		ttt.loadBoard();
		ttt.printBoard();

		

	}

}
