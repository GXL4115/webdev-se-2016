package cn.edu.nxu.it.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("t_cast", "id", Cast.class);
		arp.addMapping("t_cast_role", "id", CastRole.class);
		arp.addMapping("t_genre", "id", Genre.class);
		arp.addMapping("t_movie", "id", Movie.class);
		// Composite Primary Key order: id,movie_id
		arp.addMapping("t_movie_cast", "id,movie_id", MovieCast.class);
		// Composite Primary Key order: id,movie_id
		arp.addMapping("t_movie_genre", "id,movie_id", MovieGenre.class);
		arp.addMapping("t_user", "id", User.class);
		arp.addMapping("test", "id", Test.class);
	}
}

