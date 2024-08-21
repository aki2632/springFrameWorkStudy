package test.com.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class TestBean3 {
	private List<String> list;
	private Set<String> set;
	private Map<String, String> map;
}
