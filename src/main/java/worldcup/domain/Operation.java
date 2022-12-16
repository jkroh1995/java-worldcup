package worldcup.domain;

public enum Operation {
    MATCH_RESULT("1", ". 경기 결과 출력"),
    GROUP_RESULT("2", ". 조별 결과 출력"),
    WORLD_RESULT("3", ". 국가 경기 및 순위 결과 출력"),
    ROUND16_RESULT("4", ". 16강 진출 국가 출력"),
    EXIT("5", ". 종료");

    private static final String ERROR_OPERATION = "[ERROR] 존재하지 않는 기능 번호입니다.";
    private final String operationIndex;
    private final String operation;

    Operation(String operationIndex, String operation){
        this.operationIndex = operationIndex;
        this.operation = operation;
    }

    public String getOperationIndex() {
        return operationIndex;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation makeOperation(String inputOperation) {
        for (Operation operation : Operation.values()) {
            if (operation.getOperationIndex().equals(inputOperation)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(ERROR_OPERATION);
    }
}
