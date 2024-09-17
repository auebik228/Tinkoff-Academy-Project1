package backend.academy;

public class Hangman {
    private final String[] hangmanStages;

    public Hangman(){
        hangmanStages = new String[]{
            """
                   ------
                   |    |
                   |
                   |
                   |
                   |
                --------
                """,
                """
                       ------
                       |    |
                       |    O
                       |
                       |
                       |
                    --------
                    """,
                """
                       ------
                       |    |
                       |    O
                       |    |
                       |
                       |
                    --------
                    """,
                """
                       ------
                       |    |
                       |    O
                       |   /|
                       |
                       |
                    --------
                    """,
                """
                       ------
                       |    |
                       |    O
                       |   /|\\
                       |
                       |
                    --------
                    """,
                """
                       ------
                       |    |
                       |    O
                       |   /|\\
                       |   /
                       |
                    --------
                    """,
                """
                       ------
                       |    |
                       |    O
                       |   /|\\
                       |   / \\
                       |
                    --------
                    """
        };
    }
    public String getHangmanStage(int attemptsLeft){
        return hangmanStages[attemptsLeft];
    }
}
