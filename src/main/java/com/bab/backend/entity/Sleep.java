package com.bab.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sleep {
    int tid;
    int uid;
    List<Map<Integer,Integer>> score;
    Date create_date;


}
