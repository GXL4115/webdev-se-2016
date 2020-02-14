package cn.edu.nxu.it.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseCourse<M extends BaseCourse<M>> extends Model<M> implements IBean {

	public M setCLASSID(java.lang.Long CLASSID) {
		set("CLASSID", CLASSID);
		return (M)this;
	}


	public java.lang.Long getCLASSID() {
		return getLong("CLASSID");
	}


	public M setTITLE(java.lang.String TITLE) {
		set("TITLE", TITLE);
		return (M)this;
	}


	public java.lang.String getTITLE() {
		return getStr("TITLE");
	}


	public M setDESCRIPTION(java.lang.String DESCRIPTION) {
		set("DESCRIPTION", DESCRIPTION);
		return (M)this;
	}


	public java.lang.String getDESCRIPTION() {
		return getStr("DESCRIPTION");
	}


	public M setCREATOR(java.lang.Long CREATOR) {
		set("CREATOR", CREATOR);
		return (M)this;
	}


	public java.lang.Long getCREATOR() {
		return getLong("CREATOR");
	}


	public M setGmtCreated(java.lang.Long gmtCreated) {
		set("GMT_CREATED", gmtCreated);
		return (M)this;
	}


	public java.lang.Long getGmtCreated() {
		return getLong("GMT_CREATED");
	}


	public M setGmtModified(java.lang.Long gmtModified) {
		set("GMT_MODIFIED", gmtModified);
		return (M)this;
	}


	public java.lang.Long getGmtModified() {
		return getLong("GMT_MODIFIED");
	}


	public M setHEAD(java.lang.String HEAD) {
		set("HEAD", HEAD);
		return (M)this;
	}


	public java.lang.String getHEAD() {
		return getStr("HEAD");
	}


	public M setIsDelete(java.lang.Long isDelete) {
		set("IS_DELETE", isDelete);
		return (M)this;
	}


	public java.lang.Long getIsDelete() {
		return getLong("IS_DELETE");
	}


}
