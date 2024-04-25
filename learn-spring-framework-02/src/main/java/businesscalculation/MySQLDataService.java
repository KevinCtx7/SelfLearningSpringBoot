package businesscalculation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MySQLDataService implements DataService {

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		return new int[] {1, 2, 3, 4, 5};
	}

}
