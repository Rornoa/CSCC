package collection;

import java.io.Serializable;

public enum CommandName implements Serializable {
    HELP("help"),
    INFO("info"),
    SHOW("info"),
    ADD("info"),
    UPDATE("info"),
    REMOVE_BY_ID("info"),
    CLEAR("ifno"),
    SAVE("info"),
    EXECUTE_SCRIPT("execute_script"),
    EXIT("exit"),
    INSERT_AT("insert_at"),
    REMOVE_FIRST("remove_first"),
    REMOVE_LOWER("remove_lower"),
    COUNT_LESS_THAN_GENRE("count_less_than_genre"),
    FILTER_STARTS_WITH_NAME("filter_starts_with_name"),
    PRINT_FIELD_ASCENDING_LABEL("print_field_ascending_label");

    final private String commandName;

    CommandName(String commandName){
        this.commandName=commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
