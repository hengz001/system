package sino.gmn.service;

import java.util.List;

import sino.gmn.entity.Sjl22ApiCommand;

public interface Sjl22ApiCommandService {
	public int add(Sjl22ApiCommand obj);
	
	public Sjl22ApiCommand selectSj(int id);

	public List<Sjl22ApiCommand> selectAllSj();
}
