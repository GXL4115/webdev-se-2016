package cn.edu.nxu.it.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseScore<M extends BaseScore<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}


	public java.lang.Integer getId() {
		return getInt("id");
	}


	public M setSno(java.lang.String sno) {
		set("sno", sno);
		return (M)this;
	}


	public java.lang.String getSno() {
		return getStr("sno");
	}


	public M setCno(java.lang.String cno) {
		set("cno", cno);
		return (M)this;
	}


	public java.lang.String getCno() {
		return getStr("cno");
	}


	public M setScore(java.lang.Integer score) {
		set("score", score);
		return (M)this;
	}


	public java.lang.Integer getScore() {
		return getInt("score");
	}


}
