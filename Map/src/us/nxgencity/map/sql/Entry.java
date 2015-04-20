package us.nxgencity.map.sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.synload.framework.modules.annotations.HasMany;
import com.synload.framework.modules.annotations.HasOne;
import com.synload.framework.modules.annotations.NonSQL;
import com.synload.framework.modules.annotations.SQLTable;
import com.synload.framework.modules.annotations.sql.BigIntegerColumn;
import com.synload.framework.modules.annotations.sql.FloatColumn;
import com.synload.framework.modules.annotations.sql.LongBlobColumn;
import com.synload.framework.modules.annotations.sql.StringColumn;
import com.synload.framework.sql.Model;

@SQLTable(description = "Individual slide", name = "Entry", version = 0.2)
public class Entry extends Model {
	public Entry(ResultSet rs) {
		super(rs);
		try {
			img = this._related(IconImage.class).exec(IconImage.class);
			simg = this._related(SupportImage.class).exec(SupportImage.class);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | NoSuchMethodException
				| SecurityException | ClassNotFoundException
				| InvocationTargetException | NoSuchFieldException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Entry(Object... data){
		super(data);
		try {
			img = this._related(IconImage.class).exec(IconImage.class);
			simg = this._related(SupportImage.class).exec(SupportImage.class);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | NoSuchMethodException
				| SecurityException | ClassNotFoundException
				| InvocationTargetException | NoSuchFieldException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BigIntegerColumn(length = 10)
	public long id;
	
	@LongBlobColumn()
	@HasMany(key = "id", of = IconImage.class)
	public String icons;
	
	@LongBlobColumn()
	@HasMany(key = "id", of = SupportImage.class)
	public String images;
	
	@StringColumn(length = 500)
	public String body;
	
	@StringColumn(length = 200)
	public String title;
	
	@FloatColumn()
	public int x;
	
	@FloatColumn()
	public int y;
	
	@StringColumn(length=50)
	public String presenter;
	
	@NonSQL
	public List<IconImage> img;
	
	@NonSQL
	public List<SupportImage> simg;

	public String getPresenter() {
		return presenter;
	}
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIcons() {
		return icons;
	}
	public void setIcons(String icons) {
		this.icons = icons;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}
