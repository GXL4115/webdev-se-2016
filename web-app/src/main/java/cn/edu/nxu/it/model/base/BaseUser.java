package cn.edu.nxu.it.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public M setUSERID(java.lang.Long USERID) {
		set("USERID", USERID);
		return (M)this;
	}


	public java.lang.Long getUSERID() {
		return getLong("USERID");
	}


	public M setEMAIL(java.lang.String EMAIL) {
		set("EMAIL", EMAIL);
		return (M)this;
	}


	public java.lang.String getEMAIL() {
		return getStr("EMAIL");
	}


	public M setPASSWORD(java.lang.String PASSWORD) {
		set("PASSWORD", PASSWORD);
		return (M)this;
	}


	public java.lang.String getPASSWORD() {
		return getStr("PASSWORD");
	}


	public M setNAME(java.lang.String NAME) {
		set("NAME", NAME);
		return (M)this;
	}


	public java.lang.String getNAME() {
		return getStr("NAME");
	}


	public M setPHONE(java.lang.String PHONE) {
		set("PHONE", PHONE);
		return (M)this;
	}


	public java.lang.String getPHONE() {
		return getStr("PHONE");
	}


	public M setAGE(java.lang.Integer AGE) {
		set("AGE", AGE);
		return (M)this;
	}


	public java.lang.Integer getAGE() {
		return getInt("AGE");
	}


	public M setSEX(java.lang.Boolean SEX) {
		set("SEX", SEX);
		return (M)this;
	}


	public java.lang.Boolean isSEX() {
		return get("SEX");
	}


	public M setTYPE(java.lang.Boolean TYPE) {
		set("TYPE", TYPE);
		return (M)this;
	}


	public java.lang.Boolean isTYPE() {
		return get("TYPE");
	}


	public M setHEAD(java.lang.String HEAD) {
		set("HEAD", HEAD);
		return (M)this;
	}


	public java.lang.String getHEAD() {
		return getStr("HEAD");
	}


	public M setIsDeleted(java.lang.Long isDeleted) {
		set("IS_DELETED", isDeleted);
		return (M)this;
	}


	public java.lang.Long getIsDeleted() {
		return getLong("IS_DELETED");
	}


}
