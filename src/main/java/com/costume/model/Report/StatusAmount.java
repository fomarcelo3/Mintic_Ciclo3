package com.costume.model.Report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Fredy Marcelo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusAmount {
    private  int completed;
    private  int cancelled;
}
