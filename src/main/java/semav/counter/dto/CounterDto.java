package semav.counter.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Счетчик")
public class CounterDto {
    @Schema(description = "Имя счетчика")
    private String name;

    @Schema(description = "Значение счетчика")
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
