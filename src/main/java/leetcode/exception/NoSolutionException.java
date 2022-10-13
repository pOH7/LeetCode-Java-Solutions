package leetcode.exception;

/**
 * @author zhanglei
 * @date 2021/10/8
 */
public class NoSolutionException extends RuntimeException {
    public NoSolutionException() {}

    public NoSolutionException(String message) {
        super(message);
    }

    public NoSolutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSolutionException(Throwable cause) {
        super(cause);
    }
}
