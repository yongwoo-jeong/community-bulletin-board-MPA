package version.mpa.bbs.vo;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileVO {
	private UUID uuid;
	@NonNull
	private String nameOnServer;
	@NonNull
	private String nameOriginal;
	@NonNull
	private Integer size;
	@NonNull
	private String path;
	@NonNull
	private String extension;


}
