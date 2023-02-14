package version.mpa.bbs.mapperInterface;

import org.apache.ibatis.annotations.Param;
import version.mpa.bbs.vo.UserVO;

public interface UserMapper {
	void insertUser(@Param("newUser") UserVO newUser);
}
