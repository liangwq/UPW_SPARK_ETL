package com.unionpay.etl


import com.unionpay.conf.ConfigurationManager
import com.unionpay.constant.Constants
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}


/**
  * Created by Xue on 2016/10/20.
  */
object Create_Hive_Tables {
  //指定HIVE数据库名
  private lazy val hive_dbname =ConfigurationManager.getProperty(Constants.HIVE_DBNAME)
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Create_Hive_Tables")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    implicit val sqlContext = new HiveContext(sc)

    println("=======Create all tables on the hive=======")

    hive_acc_trans
    hive_achis_trans
    hive_active_card_acq_branch_mon
    hive_card_bind_inf
    hive_city_card
    hive_ct
    hive_discount_bas_inf
    hive_download_trans
    hive_inf_source_class
    hive_ins_inf
    hive_mchnt_para
    hive_passive_code_pay_trans
    hive_pri_acct_inf
    hive_province_card
    hive_switch_point_trans
    hive_ucbiz_cdhd_bas_inf
    hive_access_bas_inf
    hive_active_code_pay_trans
    hive_branch_acpt_ins_inf
    hive_brand_inf
    hive_card_bin
    hive_cashier_maktg_reward_dtl
    hive_cashier_point_acct_oper_dtl
    hive_chara_grp_def_bat
    hive_cups_trans
    hive_filter_app_det
    hive_filter_rule_det
    hive_inf_source_dtl
    hive_life_trans
    hive_mchnt_inf_wallet
    hive_mchnt_tp_grp
    hive_org_tdapp_activitynew
    hive_org_tdapp_device
    hive_org_tdapp_devicenew
    hive_org_tdapp_eventnew
    hive_org_tdapp_exception
    hive_org_tdapp_exceptionnew
    hive_org_tdapp_keyvalue
    hive_org_tdapp_newuser
    hive_org_tdapp_tactivity
    hive_org_tdapp_tappevent
    hive_org_tdapp_terminate
    hive_org_tdapp_tlaunch
    hive_org_tdapp_tlaunchnew
    hive_preferential_mchnt_inf
    hive_prize_bas
    hive_signer_log
    hive_ticket_bill_bas_inf
    hive_undefine_store_inf
    hive_use_td_d
    HIVE_BILL_ORDER_TRANS
    HIVE_BILL_SUB_ORDER_TRANS
    HIVE_MCHNT_TP
    HIVE_OFFLINE_POINT_TRANS
    HIVE_ONLINE_POINT_TRANS
    HIVE_PRIZE_ACTIVITY_BAS_INF
    HIVE_PRIZE_DISCOUNT_RESULT
    HIVE_PRIZE_LVL_ADD_RULE
    HIVE_PRIZE_LVL
    HIVE_STORE_TERM_RELATION

    println("=======Create all tables on the hive successfully=======")

    sc.stop()

  }

  def hive_acc_trans (implicit sqlContext: HiveContext) = {
    println("=======Create hive_acc_trans=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_acc_trans(
         |seq_id                            string    ,
         |cdhd_usr_id                       string    ,
         |card_no                           string    ,
         |trans_tfr_tm                      string    ,
         |sys_tra_no                        string    ,
         |acpt_ins_id_cd                    string    ,
         |fwd_ins_id_cd                     string    ,
         |rcv_ins_id_cd                     string    ,
         |oper_module                       string    ,
         |trans_dt                          timestamp ,
         |trans_tm                          timestamp ,
         |buss_tp                           string    ,
         |um_trans_id                       string    ,
         |swt_right_tp                      string    ,
         |bill_id                           string    ,
         |bill_nm                           string    ,
         |chara_acct_tp                     string    ,
         |trans_at                          int       ,
         |point_at                          bigint    ,
         |mchnt_tp                          string    ,
         |resp_cd                           string    ,
         |card_accptr_term_id               string    ,
         |card_accptr_cd                    string    ,
         |frist_trans_proc_start_ts         timestamp ,
         |second_trans_proc_start_ts        timestamp ,
         |third_trans_proc_start_ts         timestamp ,
         |trans_proc_end_ts                 timestamp ,
         |sys_det_cd                        string    ,
         |sys_err_cd                        string    ,
         |rec_upd_ts                        timestamp ,
         |chara_acct_nm                     string    ,
         |void_trans_tfr_tm                 string    ,
         |void_sys_tra_no                   string    ,
         |void_acpt_ins_id_cd               string    ,
         |void_fwd_ins_id_cd                string    ,
         |orig_data_elemnt                  string    ,
         |rec_crt_ts                        timestamp ,
         |discount_at                       int       ,
         |bill_item_id                      string    ,
         |chnl_inf_index                    int       ,
         |bill_num                          bigint    ,
         |addn_discount_at                  int       ,
         |pos_entry_md_cd                   string    ,
         |udf_fld                           string    ,
         |card_accptr_nm_addr               string    ,
         |msg_tp                            string    ,
         |cdhd_fk                           string    ,
         |bill_tp                           string    ,
         |bill_bat_no                       string    ,
         |bill_inf                          string    ,
         |proc_cd                           string    ,
         |trans_curr_cd                     string    ,
         |settle_at                         int       ,
         |settle_curr_cd                    string    ,
         |card_accptr_local_tm              string    ,
         |card_accptr_local_dt              string    ,
         |expire_dt                         string    ,
         |msg_settle_dt                     timestamp      ,
         |pos_cond_cd                       string    ,
         |pos_pin_capture_cd                string    ,
         |retri_ref_no                      string    ,
         |auth_id_resp_cd                   string    ,
         |notify_st                         string    ,
         |addn_private_data                 string    ,
         |addn_at                           string    ,
         |acct_id_1                         string    ,
         |acct_id_2                         string    ,
         |resv_fld                          string    ,
         |cdhd_auth_inf                     string    ,
         |sys_settle_dt                     timestamp      ,
         |recncl_in                         string    ,
         |match_in                          string    ,
         |sec_ctrl_inf                      string    ,
         |card_seq                          string    ,
         |dtl_inq_data                      string    ,
         |pri_key1                          string    ,
         |fwd_chnl_head                     string    ,
         |chswt_plat_seq                    bigint    ,
         |internal_trans_tp                 string    ,
         |settle_trans_id                   string    ,
         |trans_tp                          string    ,
         |cups_settle_dt                    string    ,
         |pri_acct_no                       string    ,
         |card_bin                          string    ,
         |req_trans_at                      int       ,
         |resp_trans_at                     int       ,
         |trans_tot_at                      int       ,
         |iss_ins_id_cd                     string    ,
         |launch_trans_tm                   string    ,
         |launch_trans_dt                   string    ,
         |mchnt_cd                          string    ,
         |fwd_proc_in                       string    ,
         |rcv_proc_in                       string    ,
         |proj_tp                           string    ,
         |usr_id                            string    ,
         |conv_usr_id                       string    ,
         |trans_st                          string    ,
         |inq_dtl_req                       string    ,
         |inq_dtl_resp                      string    ,
         |iss_ins_resv                      string    ,
         |ic_flds                           string    ,
         |cups_def_fld                      string    ,
         |id_no                             string    ,
         |cups_resv                         string    ,
         |acpt_ins_resv                     string    ,
         |rout_ins_id_cd                    string    ,
         |sub_rout_ins_id_cd                string    ,
         |recv_access_resp_cd               string    ,
         |chswt_resp_cd                     string    ,
         |chswt_err_cd                      string    ,
         |resv_fld1                         string    ,
         |resv_fld2                         string    ,
         |to_ts                             timestamp ,
         |external_amt                      int       ,
         |card_pay_at                       int       ,
         |right_purchase_at                 int       ,
         |recv_second_resp_cd               string    ,
         |req_acpt_ins_resv                 string    ,
         |log_id                            string    ,
         |conv_acct_no                      string    ,
         |inner_pro_ind                     string    ,
         |acct_proc_in                      string    ,
         |order_id                          string
         |)
         |partitioned by(part_trans_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_acc_trans successfully ! =======")

  }

  def hive_achis_trans (implicit sqlContext: HiveContext) = {
    println("=======Create hive_achis_trans=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_achis_trans(
         |settle_dt          timestamp    ,
         |trans_idx          string       ,
         |trans_tp           string       ,
         |trans_class        string       ,
         |trans_source       string       ,
         |buss_chnl          string       ,
         |carrier_tp         string       ,
         |pri_acct_no        string       ,
         |mchnt_conn_tp      string       ,
         |access_tp          string       ,
         |conn_md            string       ,
         |acq_ins_id_cd      string       ,
         |acq_head           string       ,
         |fwd_ins_id_cd      string       ,
         |rcv_ins_id_cd      string       ,
         |iss_ins_id_cd      string       ,
         |iss_head           string       ,
         |iss_head_nm        string       ,
         |mchnt_cd           string       ,
         |mchnt_nm           string       ,
         |mchnt_country      string       ,
         |mchnt_url          string       ,
         |mchnt_front_url    string       ,
         |mchnt_back_url     string       ,
         |mchnt_tp           string       ,
         |mchnt_order_id     string       ,
         |mchnt_order_desc   string       ,
         |mchnt_add_info     string       ,
         |mchnt_reserve      string       ,
         |reserve            string       ,
         |sub_mchnt_cd       string       ,
         |sub_mchnt_company  string       ,
         |sub_mchnt_nm       string       ,
         |mchnt_class        string       ,
         |sys_tra_no         string       ,
         |trans_tm           string       ,
         |sys_tm             string       ,
         |trans_dt           timestamp    ,
         |auth_id            string       ,
         |trans_at           int          ,
         |trans_curr_cd      string       ,
         |proc_st            string       ,
         |resp_cd            string       ,
         |proc_sys           string       ,
         |trans_no           string       ,
         |trans_st           string       ,
         |conv_dt            string       ,
         |settle_at          int          ,
         |settle_curr_cd     string       ,
         |settle_conv_rt     int          ,
         |cert_tp            string       ,
         |cert_id            string       ,
         |name               string       ,
         |phone_no           string       ,
         |usr_id             int          ,
         |mchnt_id           int          ,
         |pay_method         string       ,
         |trans_ip           string       ,
         |encoding           string       ,
         |mac_addr           string       ,
         |card_attr          string       ,
         |ebank_id           string       ,
         |ebank_mchnt_cd     string       ,
         |ebank_order_num    string       ,
         |ebank_idx          string       ,
         |ebank_rsp_tm       string       ,
         |kz_curr_cd         string       ,
         |kz_conv_rt         int          ,
         |kz_at              int          ,
         |delivery_country   int          ,
         |delivery_province  int          ,
         |delivery_city      int          ,
         |delivery_district  int          ,
         |delivery_street    string       ,
         |sms_tp             string       ,
         |sign_method        string       ,
         |verify_mode        string       ,
         |accpt_pos_id       string       ,
         |mer_cert_id        string       ,
         |cup_cert_id        int          ,
         |mchnt_version      string       ,
         |sub_trans_tp       string       ,
         |mac                string       ,
         |biz_tp             string       ,
         |source_idt         string       ,
         |delivery_risk      string       ,
         |trans_flag         string       ,
         |org_trans_idx      string       ,
         |org_sys_tra_no     string       ,
         |org_sys_tm         string       ,
         |org_mchnt_order_id string       ,
         |org_trans_tm       string       ,
         |org_trans_at       int          ,
         |req_pri_data       string       ,
         |pri_data           string       ,
         |addn_at            string       ,
         |res_pri_data       string       ,
         |inq_dtl            string       ,
         |reserve_fld        string       ,
         |buss_code          string       ,
         |t_mchnt_cd         string       ,
         |is_oversea         string       ,
         |points_at          int          ,
         |pri_acct_tp        string       ,
         |area_cd            string       ,
         |mchnt_fee_at       int          ,
         |user_fee_at        int          ,
         |curr_exp           string       ,
         |rcv_acct           string       ,
         |track2             string       ,
         |track3             string       ,
         |customer_nm        string       ,
         |product_info       string       ,
         |customer_email     string       ,
         |cup_branch_ins_cd  string       ,
         |org_trans_dt       timestamp    ,
         |special_calc_cost  string       ,
         |zero_cost          string       ,
         |advance_payment    string       ,
         |new_trans_tp       string       ,
         |flight_inf         string       ,
         |md_id              string       ,
         |ud_id              string       ,
         |syssp_id           string       ,
         |card_sn            string       ,
         |tfr_in_acct        string       ,
         |acct_id            string       ,
         |card_bin           string       ,
         |icc_data           string       ,
         |icc_data2          string       ,
         |card_seq_id        string       ,
         |pos_entry_cd       string       ,
         |pos_cond_cd        string       ,
         |term_id            string       ,
         |usr_num_tp         string       ,
         |addn_area_cd       string       ,
         |usr_num            string       ,
         |reserve1           string       ,
         |reserve2           string       ,
         |reserve3           string       ,
         |reserve4           string       ,
         |reserve5           string       ,
         |reserve6           string       ,
         |rec_st             string       ,
         |comments           string       ,
         |to_ts              string       ,
         |rec_crt_ts         string       ,
         |rec_upd_ts         string       ,
         |pay_acct           string       ,
         |trans_chnl         string       ,
         |tlr_st             string       ,
         |rvs_st             string       ,
         |out_trans_tp       string       ,
         |org_out_trans_tp   string       ,
         |bind_id            string       ,
         |ch_info            string       ,
         |card_risk_flag     string       ,
         |trans_step         string       ,
         |ctrl_msg           string       ,
         |mchnt_delv_tag     string       ,
         |mchnt_risk_tag     string       ,
         |bat_id             string       ,
         |payer_ip           string       ,
         |gt_sign_val        string       ,
         |mchnt_sign_val     string       ,
         |deduction_at       string       ,
         |src_sys_flag       string       ,
         |mac_ip             string       ,
         |mac_sq             string       ,
         |trans_ip_num       int          ,
         |cvn_flag           string       ,
         |expire_flag        string       ,
         |usr_inf            string       ,
         |imei               string       ,
         |iss_ins_tp         string       ,
         |dir_field          string       ,
         |buss_tp            string       ,
         |in_trans_tp        string
         |)
         |partitioned by (part_settle_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_achis_trans successfully ! =======")

  }

  def hive_active_card_acq_branch_mon (implicit sqlContext: HiveContext) = {
    println("=======Create hive_active_card_acq_branch_mon=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_active_card_acq_branch_mon(
         |trans_month             string ,
         |trans_class            string ,
         |trans_cd               string ,
         |trans_chnl_id          tinyint,
         |card_brand_id          tinyint,
         |card_attr_id           tinyint,
         |acq_intnl_org_id_cd    string ,
         |iss_root_ins_id_cd     string ,
         |active_card_num        bigint ,
         |settle_month           string
         |)
         |partitioned by (part_settle_month string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_active_card_acq_branch_mon successfully ! =======")

  }

  def hive_card_bind_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_card_bind_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_card_bind_inf(
         |cdhd_card_bind_seq     bigint    ,
         |cdhd_usr_id            string    ,
         |bind_tp                string    ,
         |bind_card_no           string    ,
         |bind_ts                timestamp ,
         |unbind_ts              timestamp ,
         |card_auth_st           string    ,
         |card_bind_st           string    ,
         |ins_id_cd              string    ,
         |auth_ts                timestamp ,
         |func_bmp               string    ,
         |rec_crt_ts             timestamp ,
         |rec_upd_ts             timestamp ,
         |ver_no                 int       ,
         |sort_seq               bigint    ,
         |cash_in                string    ,
         |acct_point_ins_id_cd   string    ,
         |acct_owner             string    ,
         |bind_source            string    ,
         |card_media             string    ,
         |backup_fld1            string    ,
         |backup_fld2            string    ,
         |iss_ins_id_cd          string    ,
         |iss_ins_cn_nm          string    ,
         |frist_bind_ts          timestamp
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_card_bind_inf successfully ! =======")

  }

  def hive_city_card (implicit sqlContext: HiveContext) = {
    println("=======Create hive_city_card=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_city_card(
         |id                      string    ,
         |name                    string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_city_card successfully ! =======")

  }

  def hive_ct (implicit sqlContext: HiveContext) = {
    println("=======Create hive_ct=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_ct(
         |id                      string    ,
         |name                    string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_ct successfully ! =======")

  }

  def hive_discount_bas_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_discount_bas_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_discount_bas_inf(
         |loc_activity_id         int        ,
         |loc_activity_nm         string     ,
         |loc_activity_desc       string     ,
         |activity_begin_dt       timestamp  ,
         |activity_end_dt         timestamp  ,
         |agio_mchnt_num          int        ,
         |eff_mchnt_num           int        ,
         |sync_bat_no             int        ,
         |sync_st                 string     ,
         |rule_upd_in             string     ,
         |rule_grp_id             int        ,
         |rec_crt_ts              timestamp  ,
         |rec_crt_usr_id          string     ,
         |rec_crt_ins_id_cd       string     ,
         |cup_branch_ins_id_nm    string     ,
         |rec_upd_ts              timestamp  ,
         |rec_upd_usr_id          string     ,
         |rec_upd_ins_id_cd       string     ,
         |del_in                  string     ,
         |ver_no                  int        ,
         |run_st                  string     ,
         |posp_from_in            string     ,
         |group_id                string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_discount_bas_inf successfully ! =======")

  }

  def hive_download_trans (implicit sqlContext: HiveContext) = {
    println("=======Create hive_download_trans=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_download_trans(
         |seq_id               bigint   ,
         |cdhd_usr_id          string   ,
         |pri_acct_no          string   ,
         |acpt_ins_id_cd       string   ,
         |fwd_ins_id_cd        string   ,
         |sys_tra_no           string   ,
         |tfr_dt_tm            string   ,
         |rcv_ins_id_cd        string   ,
         |onl_trans_tra_no     string   ,
         |mchnt_cd             string   ,
         |mchnt_nm             string   ,
         |trans_dt             timestamp,
         |trans_tm             string   ,
         |trans_at             int      ,
         |buss_tp              string   ,
         |um_trans_id          string   ,
         |swt_right_tp         string   ,
         |swt_right_nm         string   ,
         |bill_id              string   ,
         |bill_nm              string   ,
         |chara_acct_tp        string   ,
         |point_at             bigint   ,
         |bill_num             bigint   ,
         |chara_acct_nm        string   ,
         |plan_id              int      ,
         |sys_det_cd           string   ,
         |acct_addup_tp        string   ,
         |remark               string   ,
         |bill_item_id         string   ,
         |trans_st             string   ,
         |discount_at          int      ,
         |booking_st           string   ,
         |plan_nm              string   ,
         |bill_acq_md          string   ,
         |oper_in              string   ,
         |rec_crt_ts           timestamp,
         |rec_upd_ts           timestamp,
         |term_id              string   ,
         |pos_entry_md_cd      string   ,
         |orig_data_elemnt     string   ,
         |udf_fld              string   ,
         |card_accptr_nm_addr  string   ,
         |token_card_no        string
         |)
         |partitioned by(part_trans_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_download_trans successfully ! =======")

  }

  def hive_inf_source_class (implicit sqlContext: HiveContext) = {
    println("=======Create hive_inf_source_class=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_inf_source_class(
         |access_nm string ,
         |class     string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_inf_source_class successfully ! =======")

  }

  def hive_ins_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_ins_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_ins_inf(
         |ins_id_cd                     string   ,
         |ins_cata                      string   ,
         |ins_tp                        string   ,
         |hdqrs_ins_id_cd               string   ,
         |cup_branch_ins_id_cd          string   ,
         |cup_branch_ins_id_nm          string   ,
         |frn_cup_branch_ins_id_cd      string   ,
         |area_cd                       string   ,
         |admin_division_cd             string   ,
         |region_cd                     string   ,
         |ins_cn_nm                     string   ,
         |ins_cn_abbr                   string   ,
         |ins_en_nm                     string   ,
         |ins_en_abbr                   string   ,
         |ins_st                        string   ,
         |lic_no                        string   ,
         |artif_certif_id               string   ,
         |artif_nm                      string   ,
         |artif_certif_expire_dt        string   ,
         |principal_nm                  string   ,
         |contact_person_nm             string   ,
         |phone                         string   ,
         |fax_no                        string   ,
         |email_addr                    string   ,
         |ins_addr                      string   ,
         |zip_cd                        string   ,
         |oper_in                       string   ,
         |event_id                      int      ,
         |rec_id                        int      ,
         |rec_upd_usr_id                string   ,
         |rec_upd_ts                    timestamp,
         |rec_crt_ts                    timestamp
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_ins_inf successfully ! =======")

  }

  def hive_mchnt_para (implicit sqlContext: HiveContext) = {
    println("=======Create hive_mchnt_para=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_mchnt_para(
         |mchnt_para_id             bigint     ,
         |mchnt_para_cn_nm          string     ,
         |mchnt_para_en_nm          string     ,
         |mchnt_para_tp             string     ,
         |mchnt_para_level          int        ,
         |mchnt_para_parent_id      bigint     ,
         |mchnt_para_order          int        ,
         |rec_crt_ts                timestamp  ,
         |rec_upd_ts                timestamp  ,
         |ver_no                    int
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_mchnt_para successfully ! =======")

  }

  def hive_passive_code_pay_trans (implicit sqlContext: HiveContext) = {
    println("=======Create hive_passive_code_pay_trans=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_passive_code_pay_trans(
         |trans_seq              string     ,
         |cdhd_card_bind_seq     bigint     ,
         |cdhd_usr_id            string     ,
         |card_no                string     ,
         |tran_mode              string     ,
         |trans_tp               string     ,
         |tran_certi             string     ,
         |trans_rdm_num          string     ,
         |trans_expire_ts        timestamp  ,
         |order_id               string     ,
         |device_cd              string     ,
         |mchnt_cd               string     ,
         |mchnt_nm               string     ,
         |sub_mchnt_cd           string     ,
         |sub_mchnt_nm           string     ,
         |settle_dt              string     ,
         |trans_at               bigint     ,
         |discount_at            bigint     ,
         |discount_info          string     ,
         |refund_at              int        ,
         |orig_trans_seq         string     ,
         |trans_st               string     ,
         |rec_crt_ts             timestamp  ,
         |rec_upd_ts             timestamp  ,
         |trans_dt               timestamp       ,
         |resp_code              string     ,
         |resp_msg               string     ,
         |out_trade_no           string     ,
         |body                   string     ,
         |terminal_id            string     ,
         |extend_params          string
         |)
         |partitioned by (part_trans_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_passive_code_pay_trans successfully ! =======")

  }

  def hive_pri_acct_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_pri_acct_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists upw_hive.hive_pri_acct_inf(
         |cdhd_usr_id            string    ,
         |reg_dt                 timestamp      ,
         |usr_nm                 string    ,
         |mobile                 string    ,
         |mobile_vfy_st          string    ,
         |email_addr             string    ,
         |email_vfy_st           string    ,
         |inf_source             string    ,
         |real_nm                string    ,
         |real_nm_st             string    ,
         |nick_nm                string    ,
         |certif_tp              string    ,
         |certif_id              string    ,
         |certif_vfy_st          string    ,
         |birth_dt               timestamp      ,
         |sex                    string    ,
         |age                    string    ,
         |marital_st             string    ,
         |home_mem_num           string    ,
         |cntry_cd               string    ,
         |gb_region_cd           string    ,
         |comm_addr              string    ,
         |zip_cd                 string    ,
         |nationality            string    ,
         |ed_lvl                 string    ,
         |msn_no                 string    ,
         |qq_no                  string    ,
         |person_homepage        string    ,
         |industry_id            string    ,
         |annual_income_lvl      string    ,
         |hobby                  string    ,
         |brand_prefer           string    ,
         |buss_dist_prefer       string    ,
         |head_pic_file_path     string    ,
         |pwd_cue_ques           string    ,
         |pwd_cue_answ           string    ,
         |usr_eval_lvl           string    ,
         |usr_class_lvl          string    ,
         |usr_st                 string    ,
         |open_func              string    ,
         |rec_crt_ts             timestamp ,
         |rec_upd_ts             timestamp ,
         |mobile_new             string    ,
         |email_addr_new         string    ,
         |activate_ts            timestamp ,
         |activate_pwd           string    ,
         |region_cd              string    ,
         |ver_no                 int       ,
         |func_bmp               string    ,
         |point_pre_open_ts      timestamp ,
         |refer_usr_id           string    ,
         |vendor_fk              bigint    ,
         |phone                  string    ,
         |vip_svc                string    ,
         |user_lvl_id            int       ,
         |auto_adjust_lvl_in     int       ,
         |lvl_begin_dt           timestamp      ,
         |customer_title         string    ,
         |company                string    ,
         |dept                   string    ,
         |duty                   string    ,
         |resv_phone             string    ,
         |join_activity_list     string    ,
         |remark                 string    ,
         |note                   string    ,
         |usr_lvl_expire_dt      timestamp      ,
         |reg_card_no            string    ,
         |reg_tm                 string    ,
         |activity_source        string    ,
         |chsp_svc_in            string    ,
         |accept_sms_in          string    ,
         |prov_division_cd       string    ,
         |city_division_cd       string    ,
         |vid_last_login         string    ,
         |pay_pwd                string    ,
         |pwd_set_st             string    ,
         |realnm_in	       string    ,
         |birthday               string    ,
         |province_card          string    ,
         |city_card              string    ,
         |mobile_provider        string    ,
         |sex_card               string    ,
         |phone_location         string    ,
         |relate_id              string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_pri_acct_inf successfully ! =======")

  }

  def hive_province_card (implicit sqlContext: HiveContext) = {
    println("=======Create hive_province_card=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_province_card(
         |id                      string    ,
         |name                    string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_province_card successfully ! =======")

  }

  def hive_switch_point_trans (implicit sqlContext: HiveContext) = {
    println("=======Create hive_switch_point_trans=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_switch_point_trans(
         |tfr_dt_tm                   string    ,
         |sys_tra_no                  string    ,
         |acpt_ins_id_cd              string    ,
         |msg_fwd_ins_id_cd           string    ,
         |pri_key1                    string    ,
         |fwd_chnl_head               string    ,
         |chswt_plat_seq              bigint    ,
         |trans_tm                    string    ,
         |trans_dt                    timestamp ,
         |cswt_settle_dt              timestamp ,
         |internal_trans_tp           string    ,
         |settle_trans_id             string    ,
         |trans_tp                    string    ,
         |cups_settle_dt              string    ,
         |msg_tp                      string    ,
         |pri_acct_no                 string    ,
         |card_bin                    string    ,
         |proc_cd                     string    ,
         |req_trans_at                bigint    ,
         |resp_trans_at               bigint    ,
         |trans_curr_cd               string    ,
         |trans_tot_at                bigint    ,
         |iss_ins_id_cd               string    ,
         |launch_trans_tm             string    ,
         |launch_trans_dt             string    ,
         |mchnt_tp                    string    ,
         |pos_entry_md_cd             string    ,
         |card_seq_id                 string    ,
         |pos_cond_cd                 string    ,
         |pos_pin_capture_cd          string    ,
         |retri_ref_no                string    ,
         |term_id                     string    ,
         |mchnt_cd                    string    ,
         |card_accptr_nm_loc          string    ,
         |sec_related_ctrl_inf        string    ,
         |orig_data_elemts            string    ,
         |rcv_ins_id_cd               string    ,
         |fwd_proc_in                 string    ,
         |rcv_proc_in                 string    ,
         |proj_tp                     string    ,
         |usr_id                      string    ,
         |conv_usr_id                 string    ,
         |trans_st                    string    ,
         |inq_dtl_req                 string    ,
         |inq_dtl_resp                string    ,
         |iss_ins_resv                string    ,
         |ic_flds                     string    ,
         |cups_def_fld                string    ,
         |id_no                       string    ,
         |cups_resv                   string    ,
         |acpt_ins_resv               string    ,
         |rout_ins_id_cd              string    ,
         |sub_rout_ins_id_cd          string    ,
         |recv_access_resp_cd         string    ,
         |chswt_resp_cd               string    ,
         |chswt_err_cd                string    ,
         |resv_fld1                   string    ,
         |resv_fld2                   string    ,
         |to_ts                       timestamp ,
         |rec_upd_ts                  timestamp ,
         |rec_crt_ts                  timestamp ,
         |settle_at                   bigint    ,
         |external_amt                bigint    ,
         |discount_at                 bigint    ,
         |card_pay_at                 bigint    ,
         |right_purchase_at           bigint    ,
         |recv_second_resp_cd         string    ,
         |req_acpt_ins_resv           string    ,
         |log_id                      string    ,
         |conv_acct_no                string    ,
         |inner_pro_ind               string    ,
         |acct_proc_in                string    ,
         |order_id                    string
         |)
         |partitioned by(part_trans_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_switch_point_trans successfully ! =======")

  }

  def hive_ucbiz_cdhd_bas_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_ucbiz_cdhd_bas_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_ucbiz_cdhd_bas_inf(
         |usr_id                string ,
         |cntry_phone_cd        string ,
         |mobile                string ,
         |email_addr            string ,
         |usr_nm                string ,
         |nick_nm               string ,
         |new_mobile            string ,
         |email_vfy_st          string ,
         |inf_source            string ,
         |data_source           string ,
         |usr_st                string ,
         |reg_ts                string ,
         |reg_md                string ,
         |relate_id             string ,
         |access_id             string ,
         |rec_crt_ts            string ,
         |rec_upd_ts            string ,
         |wel_state             string ,
         |ip_addr               string ,
         |login_pwd             string ,
         |pay_pwd               string ,
         |union_flag            string ,
         |func_bmp              int    ,
         |ver_no                int    ,
         |func_bmp_char         string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_ucbiz_cdhd_bas_inf successfully ! =======")

  }

  def hive_access_bas_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_access_bas_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_access_bas_inf(
         |seq_id											bigint,
         |ch_ins_tp                   string,
         |ch_ins_id_cd                string,
         |ch_access_nm                string,
         |region_cd                   string,
         |cup_branch_ins_id_cd        string,
         |cup_branch_nm               string,
         |access_ins_st               string,
         |allot_md_id                 int   ,
         |extend_ins_id_cd            string,
         |extend_ins_nm               string,
         |ins_acct_id                 string,
         |req_dt                      string,
         |enable_dt                   string,
         |entry_usr_id                string,
         |entry_ts                    timestamp,
         |upd_usr_id                  string,
         |upd_ts                      timestamp,
         |oper_action                 string,
         |aud_usr_id                  string,
         |aud_idea                    string,
         |aud_ts                      timestamp,
         |aud_st                      string,
         |ver_no                      int,
         |receipt_tp                  string ,
         |event_id                    int,
         |sync_st                     string,
         |point_enable_in             string,
         |access_prov_cd              string,
         |access_city_cd              string,
         |access_district_cd          string,
         |oper_in                     string,
         |exch_in                     string,
         |exch_out                    string,
         |acpt_notify_in              string,
         |receipt_bank                string,
         |receipt_bank_acct           string,
         |receipt_bank_acct_nm        string,
         |temp_use_bmp                string,
         |term_diff_store_tp_in       string,
         |receipt_flag                string,
         |term_alter_in               string,
         |urgent_sync_in              string,
         |acpt_notify_url             string,
         |input_data_tp               string,
         |entry_ins_id_cd             string,
         |entry_ins_cn_nm             string,
         |entry_cup_branch_ins_id_cd  string,
         |entry_cup_branch_nm         string,
         |term_mt_ins_id_cd           string,
         |term_mt_ins_cn_nm           string,
         |fwd_ins_id_cd               string,
         |pri_mchnt_cd                string,
         |cup_branch_ins_id_nm        string
         |
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_access_bas_inf successfully ! =======")

  }

  def hive_active_code_pay_trans (implicit sqlContext: HiveContext) = {
    println("=======Create hive_active_code_pay_trans=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_active_code_pay_trans(
         |settle_dt           	timestamp ,
         |trans_idx               string,
         |trans_tp                string,
         |trans_class             string,
         |trans_source            string,
         |buss_chnl               string,
         |carrier_tp              string,
         |pri_acct_no             string,
         |mchnt_conn_tp           string,
         |access_tp               string,
         |conn_md                 string,
         |acq_ins_id_cd           string,
         |acq_head                string,
         |fwd_ins_id_cd           string,
         |rcv_ins_id_cd           string,
         |iss_ins_id_cd           string,
         |iss_head                string,
         |iss_head_nm             string,
         |mchnt_cd                string,
         |mchnt_nm                string,
         |mchnt_country           string,
         |mchnt_url               string,
         |mchnt_front_url         string,
         |mchnt_back_url          string,
         |mchnt_tp                string,
         |mchnt_order_id          string,
         |mchnt_order_desc        string,
         |mchnt_add_info          string,
         |mchnt_reserve           string,
         |reserve                 string,
         |sub_mchnt_cd            string,
         |sub_mchnt_company       string,
         |sub_mchnt_nm            string,
         |mchnt_class             string,
         |sys_tra_no              string,
         |trans_tm                string,
         |sys_tm                  string,
         |trans_dt                timestamp  ,
         |auth_id                 string,
         |trans_at                int   ,
         |trans_curr_cd           string,
         |proc_st                 string,
         |resp_cd                 string,
         |proc_sys                string,
         |trans_no                string,
         |trans_st                string,
         |conv_dt                 string,
         |settle_at               int   ,
         |settle_curr_cd          string,
         |settle_conv_rt          int   ,
         |cert_tp                 string,
         |cert_id                 string,
         |name                    string,
         |phone_no                string,
         |usr_id                  int   ,
         |mchnt_id                int   ,
         |pay_method              string,
         |trans_ip                string,
         |encoding                string,
         |mac_addr                string,
         |card_attr               string,
         |ebank_id                string,
         |ebank_mchnt_cd          string,
         |ebank_order_num         string,
         |ebank_idx               string,
         |ebank_rsp_tm            string,
         |kz_curr_cd              string,
         |kz_conv_rt              int   ,
         |kz_at                   int   ,
         |delivery_country        int   ,
         |delivery_province       int   ,
         |delivery_city           int   ,
         |delivery_district       int   ,
         |delivery_street         string,
         |sms_tp                  string,
         |sign_method             string,
         |verify_mode             string,
         |accpt_pos_id            string,
         |mer_cert_id             string,
         |cup_cert_id             int   ,
         |mchnt_version           string,
         |sub_trans_tp            string,
         |mac                     string,
         |biz_tp                  string,
         |source_idt              string,
         |delivery_risk           string,
         |trans_flag              string,
         |org_trans_idx           string,
         |org_sys_tra_no          string,
         |org_sys_tm              string,
         |org_mchnt_order_id      string,
         |org_trans_tm            string,
         |org_trans_at            int   ,
         |req_pri_data            string,
         |pri_data                string,
         |addn_at                 string,
         |res_pri_data            string,
         |inq_dtl                 string,
         |reserve_fld             string,
         |buss_code               string,
         |t_mchnt_cd              string,
         |is_oversea              string,
         |points_at               int   ,
         |pri_acct_tp             string,
         |area_cd                 string,
         |mchnt_fee_at            int   ,
         |user_fee_at             int   ,
         |curr_exp                string,
         |rcv_acct                string,
         |track2                  string,
         |track3                  string,
         |customer_nm             string,
         |product_info            string,
         |customer_email          string,
         |cup_branch_ins_cd       string,
         |org_trans_dt            timestamp  ,
         |special_calc_cost       string,
         |zero_cost               string,
         |advance_payment         string,
         |new_trans_tp            string,
         |flight_inf              string,
         |md_id                   string,
         |ud_id                   string,
         |syssp_id                string,
         |card_sn                 string,
         |tfr_in_acct             string,
         |acct_id                 string,
         |card_bin                string,
         |icc_data                string,
         |icc_data2               string,
         |card_seq_id             string,
         |pos_entry_cd            string,
         |pos_cond_cd             string,
         |term_id                 string,
         |usr_num_tp              string,
         |addn_area_cd            string,
         |usr_num                 string,
         |reserve1                string,
         |reserve2                string,
         |reserve3                string,
         |reserve4                string,
         |reserve5                string,
         |reserve6                string,
         |rec_st                  string,
         |comments                string,
         |to_ts                   string,
         |rec_crt_ts              string,
         |rec_upd_ts              string,
         |pay_acct                string,
         |trans_chnl              string,
         |tlr_st                  string,
         |rvs_st                  string,
         |out_trans_tp            string,
         |org_out_trans_tp        string,
         |bind_id                 string,
         |ch_info                 string,
         |card_risk_flag          string,
         |trans_step              string,
         |ctrl_msg                string,
         |mchnt_delv_tag          string,
         |mchnt_risk_tag          string,
         |bat_id                  string,
         |payer_ip                string,
         |gt_sign_val             string,
         |mchnt_sign_val          string,
         |deduction_at            string,
         |src_sys_flag            string,
         |mac_ip                  string,
         |mac_sq                  string,
         |trans_ip_num            int   ,
         |cvn_flag                string,
         |expire_flag             string,
         |usr_inf                 string,
         |imei                    string,
         |iss_ins_tp              string,
         |dir_field               string,
         |buss_tp                 string,
         |in_trans_tp             string
         |
         |)
         |partitioned by (part_settle_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_active_code_pay_trans successfully ! =======")

  }

  def hive_branch_acpt_ins_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_branch_acpt_ins_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_branch_acpt_ins_inf(
         |cup_branch_ins_id_cd   string,
         |ins_id_cd              string,
         |cup_branch_ins_id_nm   string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_branch_acpt_ins_inf successfully ! =======")

  }

  def hive_brand_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_brand_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_brand_inf(
         |brand_id			         bigint,
         |brand_nm               string,
         |buss_bmp               string,
         |cup_branch_ins_id_cd   string,
         |avg_consume            int   ,
         |brand_desc             string,
         |avg_comment            bigint,
         |brand_st               string,
         |content_id             int   ,
         |rec_crt_ts             timestamp,
         |rec_upd_ts             timestamp,
         |brand_env_grade        bigint,
         |brand_srv_grade        bigint,
         |brand_popular_grade    bigint,
         |brand_taste_grade      bigint,
         |brand_tp               string,
         |entry_ins_id_cd        string,
         |entry_ins_cn_nm        string,
         |rec_crt_usr_id         string,
         |rec_upd_usr_id         string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_brand_inf successfully ! =======")

  }

  def hive_card_bin (implicit sqlContext: HiveContext) = {
    println("=======Create hive_card_bin=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_card_bin(
         |card_bin           string,
         |card_cn_nm         string,
         |card_en_nm         string,
         |iss_ins_id_cd      string,
         |iss_ins_cn_nm      string,
         |iss_ins_en_nm      string,
         |card_bin_len       int,
         |card_attr          string,
         |card_cata          string,
         |card_class         string,
         |card_brand         string,
         |card_prod          string,
         |card_lvl           string,
         |card_media         string,
         |ic_app_tp          string,
         |pan_len            string,
         |pan_sample         string,
         |pay_curr_cd1       string,
         |pay_curr_cd2       string,
         |pay_curr_cd3       string,
         |card_bin_priv_bmp  string,
         |publish_dt         timestamp,
         |card_vfy_algo      string,
         |frn_trans_in       string,
         |oper_in            string,
         |event_id           int,
         |rec_id             int,
         |rec_upd_usr_id     string,
         |rec_upd_ts         timestamp,
         |rec_crt_ts         timestamp
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_card_bin successfully ! =======")

  }

  def hive_cashier_maktg_reward_dtl (implicit sqlContext: HiveContext) = {
    println("=======Create hive_cashier_maktg_reward_dtl=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         create table if not exists $hive_dbname.hive_cashier_maktg_reward_dtl(
         |seq_id                bigint,
         |trans_tfr_tm          string,
         |sys_tra_no            string,
         |acpt_ins_id_cd        string,
         |fwd_ins_id_cd         string,
         |trans_id              string,
         |pri_acct_no           string,
         |trans_at              bigint,
         |remain_trans_at       bigint,
         |settle_dt             timestamp,
         |mchnt_tp              string,
         |iss_ins_id_cd         string,
         |acq_ins_id_cd         string,
         |cup_branch_ins_id_cd  string,
         |mchnt_cd              string,
         |term_id               string,
         |trans_curr_cd         string,
         |trans_chnl            string,
         |orig_tfr_dt_tm        string,
         |orig_sys_tra_no       string,
         |orig_acpt_ins_id_cd   string,
         |orig_fwd_ins_id_cd    string,
         |loc_activity_id       int,
         |prize_lvl             int,
         |activity_tp           string,
         |reward_point_rate     bigint,
         |reward_point_max      bigint,
         |prize_result_seq      int,
         |trans_direct          string,
         |reward_usr_tp         string,
         |cdhd_usr_id           string,
         |mobile                string,
         |reward_card_no        string,
         |reward_point_at       int,
         |bill_id               string,
         |reward_bill_num       int,
         |prize_dt              string,
         |rec_crt_dt            string,
         |acct_dt               string,
         |rec_st                string,
         |rec_crt_ts            timestamp,
         |rec_upd_ts            timestamp,
         |over_plan_in          string,
         |is_match_in           string,
         |rebate_activity_id    int,
         |rebate_activity_nm    string,
         |rebate_prize_lvl      int,
         |buss_tp               string,
         |ins_acct_id           string,
         |chara_acct_tp         string,
         |trans_pri_key         string,
         |orig_trans_pri_key    string,
         |cup_branch_ins_id_nm  string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_cashier_maktg_reward_dtl successfully ! =======")

  }

  def hive_cashier_point_acct_oper_dtl (implicit sqlContext: HiveContext) = {
    println("=======Create hive_cashier_point_acct_oper_dtl=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_cashier_point_acct_oper_dtl(
         | acct_oper_id					bigint ,
         | cashier_usr_id       string ,
         | acct_oper_ts         timestamp ,
         | acct_oper_point_at   bigint,
         | acct_oper_related_id string,
         | acct_oper_tp         string,
         | ver_no               int
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_cashier_point_acct_oper_dtl successfully ! =======")

  }

  def hive_chara_grp_def_bat (implicit sqlContext: HiveContext) = {
    println("=======Create hive_chara_grp_def_bat=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_chara_grp_def_bat(
         |rec_id                       bigint,
         |chara_grp_cd                 string,
         |chara_grp_nm                 string,
         |chara_data                   string,
         |chara_data_tp                string,
         |aud_usr_id                   string,
         |aud_idea                     string,
         |aud_ts                       timestamp ,
         |aud_in                       string,
         |oper_action                  string,
         |rec_crt_ts                   timestamp,
         |rec_upd_ts                   timestamp,
         |rec_crt_usr_id               string,
         |rec_upd_usr_id               string,
         |ver_no                       int,
         |event_id                     int,
         |oper_in                      string,
         |sync_st                      string,
         |cup_branch_ins_id_cd         string,
         |input_data_tp                string,
         |brand_id                     bigint,
         |entry_ins_id_cd              string,
         |entry_ins_cn_nm              string,
         |entry_cup_branch_ins_id_cd   string,
         |order_in_grp                 int
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_chara_grp_def_bat successfully ! =======")

  }

  def hive_cups_trans (implicit sqlContext: HiveContext) = {
    println("=======Create hive_cups_trans=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_cups_trans(
         |settle_dt									timestamp ,
         |pri_key                   string,
         |log_cd                    string,
         |settle_tp                 string,
         |settle_cycle              string,
         |block_id                  string,
         |orig_key                  string,
         |related_key               string,
         |trans_fwd_st              string,
         |trans_rcv_st              string,
         |sms_dms_conv_in           string,
         |fee_in                    string,
         |cross_dist_in             string,
         |orig_acpt_sdms_in         string,
         |tfr_in_in                 string,
         |trans_md                  string,
         |source_region_cd          string,
         |dest_region_cd            string,
         |cups_card_in              string,
         |cups_sig_card_in          string,
         |card_class                string,
         |card_attr                 string,
         |sti_in                    string,
         |trans_proc_in             string,
         |acq_ins_id_cd             string,
         |acq_ins_tp                string,
         |fwd_ins_id_cd             string,
         |fwd_ins_tp                string,
         |rcv_ins_id_cd             string,
         |rcv_ins_tp                string,
         |iss_ins_id_cd             string,
         |iss_ins_tp                string,
         |related_ins_id_cd         string,
         |related_ins_tp            string,
         |acpt_ins_id_cd            string,
         |acpt_ins_tp               string,
         |pri_acct_no               string,
         |pri_acct_no_conv          string,
         |sys_tra_no                string,
         |sys_tra_no_conv           string,
         |sw_sys_tra_no             string,
         |auth_dt                   string,
         |auth_id_resp_cd           string,
         |resp_cd1                  string,
         |resp_cd2                  string,
         |resp_cd3                  string,
         |resp_cd4                  string,
         |cu_trans_st               string,
         |sti_takeout_in            string,
         |trans_id                  string,
         |trans_tp                  string,
         |trans_chnl                string,
         |card_media                string,
         |card_media_proc_md        string,
         |card_brand                string,
         |expire_seg                string,
         |trans_id_conv             string,
         |settle_mon                string,
         |settle_d                  string,
         |orig_settle_dt            timestamp ,
         |settle_fwd_ins_id_cd      string,
         |settle_rcv_ins_id_cd      string,
         |trans_at                  int ,
         |orig_trans_at             int ,
         |trans_conv_rt             int ,
         |trans_curr_cd             string ,
         |cdhd_fee_at               int,
         |cdhd_fee_conv_rt          int,
         |cdhd_fee_acct_curr_cd     string,
         |repl_at                   string,
         |exp_snd_chnl              string,
         |confirm_exp_chnl          string,
         |extend_inf                string,
         |conn_md                   string,
         |msg_tp                    string,
         |msg_tp_conv               string,
         |card_bin                  string,
         |related_card_bin          string,
         |trans_proc_cd             string,
         |trans_proc_cd_conv        string,
         |tfr_dt_tm                 string,
         |loc_trans_tm              string,
         |loc_trans_dt              string,
         |conv_dt                   string,
         |mchnt_tp                  string,
         |pos_entry_md_cd           string,
         |card_seq                  string,
         |pos_cond_cd               string,
         |pos_cond_cd_conv          string,
         |retri_ref_no              string,
         |term_id                   string,
         |term_tp                   string,
         |mchnt_cd                  string,
         |card_accptr_nm_addr       string,
         |ic_data                   string,
         |rsn_cd                    string,
         |addn_pos_inf              string,
         |orig_msg_tp               string,
         |orig_msg_tp_conv          string,
         |orig_sys_tra_no           string,
         |orig_sys_tra_no_conv      string,
         |orig_tfr_dt_tm            string,
         |related_trans_id          string,
         |related_trans_chnl        string,
         |orig_trans_id             string,
         |orig_trans_id_conv        string,
         |orig_trans_chnl           string,
         |orig_card_media           string,
         |orig_card_media_proc_md   string,
         |tfr_in_acct_no            string,
         |tfr_out_acct_no           string,
         |cups_resv                 string,
         |ic_flds                   string,
         |cups_def_fld              string,
         |spec_settle_in            string,
         |settle_trans_id           string,
         |spec_mcc_in               string,
         |iss_ds_settle_in          string,
         |acq_ds_settle_in          string,
         |settle_bmp                string,
         |upd_in                    string,
         |exp_rsn_cd                string,
         |to_ts                     string,
         |resnd_num                 int   ,
         |pri_cycle_no              string,
         |alt_cycle_no              string,
         |corr_pri_cycle_no         string,
         |corr_alt_cycle_no         string,
         |disc_in                   string,
         |vfy_rslt                  string,
         |vfy_fee_cd                string,
         |orig_disc_in              string,
         |orig_disc_curr_cd         string,
         |fwd_settle_at             int   ,
         |rcv_settle_at             int   ,
         |fwd_settle_conv_rt        int   ,
         |rcv_settle_conv_rt        int   ,
         |fwd_settle_curr_cd        string,
         |rcv_settle_curr_cd        string,
         |disc_cd                   string,
         |allot_cd                  string,
         |total_disc_at             int   ,
         |fwd_orig_settle_at        int   ,
         |rcv_orig_settle_at        int   ,
         |vfy_fee_at                int   ,
         |sp_mchnt_cd               string,
         |acct_ins_id_cd            string,
         |iss_ins_id_cd1            string,
         |iss_ins_id_cd2            string,
         |iss_ins_id_cd3            string,
         |iss_ins_id_cd4            string,
         |mchnt_ins_id_cd1          string,
         |mchnt_ins_id_cd2          string,
         |mchnt_ins_id_cd3          string,
         |mchnt_ins_id_cd4          string,
         |term_ins_id_cd1           string,
         |term_ins_id_cd2           string,
         |term_ins_id_cd3           string,
         |term_ins_id_cd4           string,
         |term_ins_id_cd5           string,
         |acpt_cret_disc_at         int,
         |acpt_debt_disc_at         int,
         |iss1_cret_disc_at         int,
         |iss1_debt_disc_at         int,
         |iss2_cret_disc_at         int,
         |iss2_debt_disc_at         int,
         |iss3_cret_disc_at         int,
         |iss3_debt_disc_at         int,
         |iss4_cret_disc_at         int,
         |iss4_debt_disc_at         int,
         |mchnt1_cret_disc_at       int,
         |mchnt1_debt_disc_at       int,
         |mchnt2_cret_disc_at       int,
         |mchnt2_debt_disc_at       int,
         |mchnt3_cret_disc_at       int,
         |mchnt3_debt_disc_at       int,
         |mchnt4_cret_disc_at       int,
         |mchnt4_debt_disc_at       int,
         |term1_cret_disc_at        int,
         |term1_debt_disc_at        int,
         |term2_cret_disc_at        int,
         |term2_debt_disc_at        int,
         |term3_cret_disc_at        int,
         |term3_debt_disc_at        int,
         |term4_cret_disc_at        int,
         |term4_debt_disc_at        int,
         |term5_cret_disc_at        int,
         |term5_debt_disc_at        int,
         |pay_in                    string,
         |exp_id                    string,
         |vou_in                    string,
         |orig_log_cd               string,
         |related_log_cd            string,
         |mdc_key                   string,
         |rec_upd_ts                string,
         |rec_crt_ts                string,
         |hp_settle_dt              string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_cups_trans successfully ! =======")

  }

  def hive_filter_app_det (implicit sqlContext: HiveContext) = {
    println("=======Create hive_filter_app_det=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_filter_app_det(
         |app_id						int   ,
         |app_usage_id      string,
         |rule_grp_cata     string,
         |activity_plat     string,
         |loc_activity_id   int   ,
         |sync_st           string,
         |sync_bat_no       int   ,
         |rule_grp_id       int   ,
         |oper_in           string,
         |event_id          int   ,
         |rec_id            int   ,
         |rec_crt_usr_id    string,
         |rec_crt_ts        timestamp,
         |rec_upd_usr_id    string ,
         |rec_upd_ts        timestamp ,
         |del_in            string  ,
         |ver_no            int
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_filter_app_det successfully ! =======")

  }

  def hive_filter_rule_det (implicit sqlContext: HiveContext) = {
    println("=======Create hive_filter_rule_det=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         create table if not exists $hive_dbname.hive_filter_rule_det(
         |rule_grp_id			int ,
         |rule_grp_cata   string,
         |rule_min_val    string,
         |rule_max_val    string,
         |activity_plat   string,
         |sync_st         string,
         |sync_bat_no     int ,
         |oper_in         string,
         |event_id        int ,
         |rec_id          int ,
         |rec_crt_usr_id  string,
         |rec_crt_ts      timestamp,
         |rec_upd_usr_id  string ,
         |rec_upd_ts      timestamp,
         |del_in          string ,
         |ver_no          int
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_filter_rule_det successfully ! =======")

  }

  def hive_inf_source_dtl (implicit sqlContext: HiveContext) = {
    println("=======Create hive_inf_source_dtl=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_inf_source_dtl(
         |access_id string,
         |access_nm string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_inf_source_dtl successfully ! =======")

  }

  def hive_life_trans (implicit sqlContext: HiveContext) = {
    println("=======Create hive_life_trans=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_life_trans(
         |settle_dt           timestamp,
         |trans_idx           string,
         |trans_tp            string,
         |trans_class         string,
         |trans_source        string,
         |buss_chnl           string,
         |carrier_tp          string,
         |pri_acct_no         string,
         |mchnt_conn_tp       string,
         |access_tp           string,
         |conn_md             string,
         |acq_ins_id_cd       string,
         |acq_head            string,
         |fwd_ins_id_cd       string,
         |rcv_ins_id_cd       string,
         |iss_ins_id_cd       string,
         |iss_head            string,
         |iss_head_nm         string,
         |mchnt_cd            string,
         |mchnt_nm            string,
         |mchnt_country       string,
         |mchnt_url           string,
         |mchnt_front_url     string,
         |mchnt_back_url      string,
         |mchnt_tp            string,
         |mchnt_order_id      string,
         |mchnt_order_desc    string,
         |mchnt_add_info      string,
         |mchnt_reserve       string,
         |reserve             string,
         |sub_mchnt_cd        string,
         |sub_mchnt_company   string,
         |sub_mchnt_nm        string,
         |mchnt_class         string,
         |sys_tra_no          string,
         |trans_tm            string,
         |sys_tm              string,
         |trans_dt            timestamp,
         |auth_id             string,
         |trans_at            int,
         |trans_curr_cd       string,
         |proc_st             string,
         |resp_cd             string,
         |proc_sys            string,
         |trans_no            string,
         |trans_st            string,
         |conv_dt             string,
         |settle_at           int,
         |settle_curr_cd      string,
         |settle_conv_rt      int,
         |cert_tp             string,
         |cert_id             string,
         |name                string,
         |phone_no            string,
         |usr_id              int,
         |mchnt_id            int,
         |pay_method          string,
         |trans_ip            string,
         |encoding            string,
         |mac_addr            string,
         |card_attr           string,
         |ebank_id            string,
         |ebank_mchnt_cd      string,
         |ebank_order_num     string,
         |ebank_idx           string,
         |ebank_rsp_tm        string,
         |kz_curr_cd          string,
         |kz_conv_rt          int,
         |kz_at               int,
         |delivery_country    int,
         |delivery_province   int,
         |delivery_city       int,
         |delivery_district   int,
         |delivery_street     string,
         |sms_tp              string,
         |sign_method         string,
         |verify_mode         string,
         |accpt_pos_id        string,
         |mer_cert_id         string,
         |cup_cert_id         int,
         |mchnt_version       string,
         |sub_trans_tp        string,
         |mac                 string,
         |biz_tp              string,
         |source_idt          string,
         |delivery_risk       string,
         |trans_flag          string,
         |org_trans_idx       string,
         |org_sys_tra_no      string,
         |org_sys_tm          string,
         |org_mchnt_order_id  string,
         |org_trans_tm        string,
         |org_trans_at        int,
         |req_pri_data        string,
         |pri_data            string,
         |addn_at             string,
         |res_pri_data        string,
         |inq_dtl             string,
         |reserve_fld         string,
         |buss_code           string,
         |t_mchnt_cd          string,
         |is_oversea          string,
         |points_at           int,
         |pri_acct_tp         string,
         |area_cd             string,
         |mchnt_fee_at        int,
         |user_fee_at         int,
         |curr_exp            string,
         |rcv_acct            string,
         |track2              string,
         |track3              string,
         |customer_nm         string,
         |product_info        string,
         |customer_email      string,
         |cup_branch_ins_cd   string,
         |org_trans_dt        timestamp  ,
         |special_calc_cost   string,
         |zero_cost           string,
         |advance_payment     string,
         |new_trans_tp        string,
         |flight_inf          string,
         |md_id               string,
         |ud_id               string,
         |syssp_id            string,
         |card_sn             string,
         |tfr_in_acct         string,
         |acct_id             string,
         |card_bin            string,
         |icc_data            string,
         |icc_data2           string,
         |card_seq_id         string,
         |pos_entry_cd        string,
         |pos_cond_cd         string,
         |term_id             string,
         |usr_num_tp          string,
         |addn_area_cd        string,
         |usr_num             string,
         |reserve1            string,
         |reserve2            string,
         |reserve3            string,
         |reserve4            string,
         |reserve5            string,
         |reserve6            string,
         |rec_st              string,
         |comments            string,
         |to_ts               string,
         |rec_crt_ts          string,
         |rec_upd_ts          string,
         |pay_acct            string,
         |trans_chnl          string,
         |tlr_st              string,
         |rvs_st              string,
         |out_trans_tp        string,
         |org_out_trans_tp    string,
         |bind_id             string,
         |ch_info             string,
         |card_risk_flag      string,
         |trans_step          string,
         |ctrl_msg            string,
         |mchnt_delv_tag      string,
         |mchnt_risk_tag      string,
         |bat_id              string,
         |payer_ip            string,
         |gt_sign_val         string,
         |mchnt_sign_val      string,
         |deduction_at        string,
         |src_sys_flag        string,
         |mac_ip              string,
         |mac_sq              string,
         |trans_ip_num        int   ,
         |cvn_flag            string,
         |expire_flag         string,
         |usr_inf             string,
         |imei                string,
         |iss_ins_tp          string,
         |dir_field           string,
         |buss_tp             string,
         |in_trans_tp         string,
         |buss_tp_nm          string,
         |chnl_tp_nm          string
         |)
         |partitioned by (part_settle_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_life_trans successfully ! =======")

  }

  def hive_mchnt_inf_wallet (implicit sqlContext: HiveContext) = {
    println("=======Create hive_mchnt_inf_wallet=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_mchnt_inf_wallet(
         |mchnt_cd               string,
         |mchnt_cn_abbr          string,
         |mchnt_cn_nm            string,
         |mchnt_en_abbr          string,
         |mchnt_en_nm            string,
         |cntry_cd               string,
         |mchnt_st               string,
         |mchnt_tp               string,
         |region_cd              string,
         |cup_branch_ins_id_cd   string,
         |cup_branch_ins_id_nm   string,
         |frn_acq_ins_id_cd      string,
         |acq_access_ins_id_cd   string,
         |acpt_ins_id_cd         string,
         |mchnt_grp              string,
         |gb_region_cd           string,
         |gb_region_nm           string,
         |acq_ins_id_cd          string,
         |oper_in                string,
         |buss_addr              string,
         |point_conv_in          string,
         |event_id               string,
         |rec_id                 string,
         |rec_upd_usr_id         string,
         |rec_upd_ts             timestamp,
         |rec_crt_ts             timestamp,
         |artif_certif_tp        string,
         |artif_certif_id        string,
         |phone                  string,
         |conn_md                string,
         |settle_ins_tp          string,
         |open_buss_bmp          string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_mchnt_inf_wallet successfully ! =======")

  }

  def hive_mchnt_tp_grp (implicit sqlContext: HiveContext) = {
    println("=======Create hive_mchnt_tp_grp=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_mchnt_tp_grp(
         |mchnt_tp_grp						string,
         |mchnt_tp_grp_desc_cn    string,
         |mchnt_tp_grp_desc_en    string,
         |rec_id                  int   ,
         |rec_st                  string,
         |last_oper_in            string,
         |rec_upd_usr_id          string,
         |rec_upd_ts              timestamp,
         |rec_crt_ts              timestamp,
         |sync_st                 string ,
         |sync_bat_no             int    ,
         |sync_ts                 timestamp
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_mchnt_tp_grp successfully ! =======")

  }

  def hive_org_tdapp_activitynew (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_activitynew=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_activitynew(
         |loguuid							string,
         |developerid         int   ,
         |productid           int   ,
         |platformid          int   ,
         |partnerid           int   ,
         |appversion          string,
         |tduserid            int   ,
         |mobileid            int   ,
         |channel             int   ,
         |os                  int   ,
         |pixel               string,
         |countryid           int   ,
         |provinceid          int   ,
         |isp                 int   ,
         |language            string,
         |jailbroken          int   ,
         |cracked             int   ,
         |starttime_hour      int   ,
         |starttime_day       int   ,
         |starttime_week      int   ,
         |starttime_month     int   ,
         |starttime_year      int   ,
         |daytime             string,
         |updays              string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_activitynew successfully ! =======")

  }

  def hive_org_tdapp_device (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_device=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_device(
         |loguuid					string,
         |developerid     int   ,
         |productid       int   ,
         |platformid      int   ,
         |partnerid       int   ,
         |appversion      string,
         |tduserid        int   ,
         |mobileid        int   ,
         |channel         int   ,
         |os              int   ,
         |pixel           string,
         |countryid       int   ,
         |provinceid      int   ,
         |isp             int   ,
         |language        string,
         |jailbroken      int   ,
         |cracked         int   ,
         |starttime_hour  int   ,
         |starttime_day   int   ,
         |starttime_week  int   ,
         |starttime_month int   ,
         |starttime_year  int   ,
         |return_status   int   ,
         |daytime         string,
         |updays          string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_device successfully ! =======")

  }

  def hive_org_tdapp_devicenew (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_devicenew=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_devicenew(
         |loguuid					 string,
         |developerid      int   ,
         |productid        int   ,
         |platformid       int   ,
         |partnerid        int   ,
         |appversion       string,
         |tduserid         int   ,
         |mobileid         int   ,
         |channel          int   ,
         |os               int   ,
         |pixel            string,
         |countryid        int   ,
         |provinceid       int   ,
         |isp              int   ,
         |language         string,
         |jailbroken       int   ,
         |cracked          int   ,
         |starttime_hour   int   ,
         |starttime_day    int   ,
         |starttime_week   int   ,
         |starttime_month  int   ,
         |starttime_year   int   ,
         |return_status    int   ,
         |daytime          string,
         |updays           string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_devicenew successfully ! =======")

  }

  def hive_org_tdapp_eventnew (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_eventnew=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_eventnew(
         |loguuid						string,
         |developerid       int   ,
         |productid         int   ,
         |platformid        int   ,
         |partnerid         int   ,
         |appversion        string,
         |tduserid          int   ,
         |mobileid          int   ,
         |channel           int   ,
         |os                int   ,
         |pixel             string,
         |countryid         int   ,
         |provinceid        int   ,
         |isp               int   ,
         |language          string,
         |jailbroken        int   ,
         |cracked           int   ,
         |starttime_hour    int   ,
         |starttime_day     int   ,
         |starttime_week    int   ,
         |starttime_month   int   ,
         |starttime_year    int   ,
         |daytime           string,
         |updays            string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_eventnew successfully ! =======")

  }

  def hive_org_tdapp_exception (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_exception=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_exception(
         |loguuid					 string,
         |developerid      int   ,
         |productid        int   ,
         |platformid       int   ,
         |partnerid        int   ,
         |appversion       string,
         |tduserid         int   ,
         |mobileid         int   ,
         |channel          int   ,
         |os               int   ,
         |pixel            string,
         |countryid        int   ,
         |provinceid       int   ,
         |isp              int   ,
         |language         string,
         |jailbroken       int   ,
         |cracked          int   ,
         |starttime_hour   int   ,
         |starttime_day    int   ,
         |starttime_week   int   ,
         |starttime_month  int   ,
         |starttime_year   int   ,
         |return_status    int   ,
         |daytime          string,
         |updays           string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_exception successfully ! =======")

  }

  def hive_org_tdapp_exceptionnew (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_exceptionnew=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_exceptionnew(
         |loguuid					string,
         |developerid     int   ,
         |productid       int   ,
         |platformid      int   ,
         |partnerid       int   ,
         |appversion      string,
         |tduserid        int   ,
         |mobileid        int   ,
         |channel         int   ,
         |os              int   ,
         |pixel           string,
         |countryid       int   ,
         |provinceid      int   ,
         |isp             int   ,
         |language        string,
         |jailbroken      int   ,
         |cracked         int   ,
         |starttime_hour  int   ,
         |starttime_day   int   ,
         |starttime_week  int   ,
         |starttime_month int   ,
         |starttime_year  int   ,
         |return_status   int   ,
         |daytime         string,
         |updays          string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_exceptionnew successfully ! =======")

  }

  def hive_org_tdapp_keyvalue (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_keyvalue=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_keyvalue(
         |loguuid						string,
         |developerid       int,
         |productid         int,
         |platformid        int,
         |partnerid         int,
         |appversion        string,
         |eventid           string,
         |label             string,
         |eventcount        int ,
         |keystring         string,
         |value             string,
         |valuenumber       int ,
         |type              string,
         |starttime         bigint,
         |starttime_hour    int,
         |starttime_day     int,
         |starttime_week    int,
         |starttime_month   int,
         |starttime_year    int,
         |daytime           string,
         |updays            string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_keyvalue successfully ! =======")

  }

  def hive_org_tdapp_newuser (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_newuser=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_newuser(
         |loguuid					string,
         |developerid     int   ,
         |productid       int   ,
         |platformid      int   ,
         |partnerid       int   ,
         |appversion      string,
         |tduserid        int   ,
         |mobileid        int   ,
         |channel         int   ,
         |os              int   ,
         |pixel           string,
         |countryid       int   ,
         |provinceid      int   ,
         |isp             int   ,
         |language        string,
         |jailbroken      int   ,
         |cracked         int   ,
         |starttime_hour  int   ,
         |starttime_day   int   ,
         |starttime_week  int   ,
         |starttime_month int   ,
         |starttime_year  int   ,
         |daytime         string,
         |updays          string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_newuser successfully ! =======")

  }

  def hive_org_tdapp_tactivity (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_tactivity=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_tactivity(
         |loguuid					string,
         |developerid     int,
         |productid       int,
         |platformid      int,
         |partnerid       int,
         |appversion      string,
         |tduserid        int,
         |refpagenameid   int,
         |pagenameid      int,
         |duration        int,
         |sessionid       string,
         |starttime       bigint,
         |starttime_hour  int,
         |starttime_day   int,
         |starttime_week  int,
         |starttime_month int,
         |starttime_year  int,
         |daytime         string,
         |updays          string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_tactivity successfully ! =======")

  }

  def hive_org_tdapp_tappevent (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_tappevent=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_tappevent(
         |loguuid						string,
         |developerid       int   ,
         |productid         int   ,
         |platformid        int   ,
         |partnerid         int   ,
         |appversion        string,
         |tduserid          int   ,
         |eventid           string,
         |label             string,
         |eventcount        int   ,
         |starttime         bigint,
         |starttime_hour    int   ,
         |starttime_day     int   ,
         |starttime_week    int   ,
         |starttime_month   int   ,
         |starttime_year    int   ,
         |daytime           string,
         |updays            string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_tappevent successfully ! =======")

  }

  def hive_org_tdapp_terminate (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_terminate=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_terminate(
         |loguuid						string,
         |developerid       int   ,
         |productid         int   ,
         |platformid        int   ,
         |partnerid         int   ,
         |appversion        string,
         |devid             string,
         |sessionid         string,
         |session_duration  int   ,
         |usetime_level     int   ,
         |starttime         bigint,
         |starttime_hour    int   ,
         |starttime_day     int   ,
         |starttime_week    int   ,
         |starttime_month   int   ,
         |starttime_year    int   ,
         |daytime           string,
         |updays            string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_terminate successfully ! =======")

  }

  def hive_org_tdapp_tlaunch (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_tlaunch=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_tlaunch(
         |loguuid						string,
         |developerid       int,
         |productid         int,
         |platformid        int,
         |partnerid         int,
         |appversion        string,
         |tduserid          int ,
         |mobileid          int ,
         |channel           int ,
         |os                int ,
         |pixel             string,
         |countryid         int,
         |provinceid        int,
         |isp               int,
         |language          string,
         |jailbroken        int ,
         |cracked           int ,
         |sessionid         string,
         |session_duration  int ,
         |interval_level    int ,
         |starttime         bigint,
         |starttime_hour    int ,
         |starttime_day     int ,
         |starttime_week    int ,
         |starttime_month   int ,
         |starttime_year    int ,
         |daytime           string,
         |updays            string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_tlaunch successfully ! =======")

  }

  def hive_org_tdapp_tlaunchnew (implicit sqlContext: HiveContext) = {
    println("=======Create hive_org_tdapp_tlaunchnew=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_org_tdapp_tlaunchnew(
         |loguuid					string,
         |developerid     int   ,
         |productid       int   ,
         |platformid      int   ,
         |partnerid       int   ,
         |appversion      string,
         |tduserid        int   ,
         |mobileid        int   ,
         |channel         int   ,
         |os              int   ,
         |pixel           string,
         |countryid       int   ,
         |provinceid      int   ,
         |isp             int   ,
         |language        string,
         |jailbroken      int   ,
         |cracked         int   ,
         |starttime_hour  int   ,
         |starttime_day   int   ,
         |starttime_week  int   ,
         |starttime_month int   ,
         |starttime_year  int   ,
         |daytime         string,
         |updays          string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_org_tdapp_tlaunchnew successfully ! =======")

  }

  def hive_preferential_mchnt_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_preferential_mchnt_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_preferential_mchnt_inf(
         |mchnt_cd                  string,
         |mchnt_nm                  string,
         |mchnt_addr                string,
         |mchnt_phone               string,
         |mchnt_url                 string,
         |mchnt_city_cd             string,
         |mchnt_county_cd           string,
         |mchnt_prov                string,
         |buss_dist_cd              bigint,
         |mchnt_type_id             bigint,
         |cooking_style_id          bigint,
         |rebate_rate               bigint,
         |discount_rate             bigint,
         |avg_consume               int   ,
         |point_mchnt_in            string,
         |discount_mchnt_in         string,
         |preferential_mchnt_in     string,
         |opt_sort_seq              int   ,
         |keywords                  string,
         |mchnt_desc                string,
         |rec_crt_ts                timestamp,
         |rec_upd_ts                timestamp,
         |encr_loc_inf              string ,
         |comment_num               int,
         |favor_num                 int,
         |share_num                 int,
         |park_inf                  string,
         |buss_hour                 string,
         |traffic_inf               string,
         |famous_service            string,
         |comment_value             int,
         |content_id                int,
         |mchnt_st                  string,
         |mchnt_first_para          bigint,
         |mchnt_second_para         bigint,
         |mchnt_longitude           decimal(15,12),
         |mchnt_latitude            decimal(15,12),
         |mchnt_longitude_web       decimal(15,12),
         |mchnt_latitude_web        decimal(15,12),
         |cup_branch_ins_id_cd      string,
         |branch_nm                 string,
         |brand_id                  bigint,
         |buss_bmp                  string,
         |term_diff_store_tp_in     string,
         |rec_id                    bigint,
         |amap_longitude            decimal(15,12),
         |amap_latitude             decimal(15,12),
         |prov_division_cd          string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_preferential_mchnt_inf successfully ! =======")

  }

  def hive_prize_bas (implicit sqlContext: HiveContext) = {
    println("=======Create hive_prize_bas=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_prize_bas(
         |loc_activity_id    int ,
         |prize_tp           string,
         |activity_plat      string,
         |sync_st            string,
         |sync_bat_no        int ,
         |prize_id           int ,
         |prize_st           string,
         |prize_lvl_num      int   ,
         |prize_nm           string,
         |prize_begin_dt     string,
         |prize_end_dt       string,
         |week_tm_bmp        string,
         |oper_in            string,
         |event_id           int ,
         |rec_id             int ,
         |rec_upd_usr_id     string,
         |rec_upd_ts         timestamp,
         |rec_crt_ts         timestamp,
         |rec_crt_usr_id     string,
         |del_in             string,
         |ver_no             int
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_prize_bas successfully ! =======")

  }

  def hive_signer_log (implicit sqlContext: HiveContext) = {
    println("=======Create hive_signer_log=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_signer_log(
         |mchnt_cd						 string,
         |term_id              string,
         |cashier_trans_tm     string,
         |pri_acct_no          string,
         |sync_bat_no          string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_signer_log successfully ! =======")

  }

  def hive_ticket_bill_bas_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_ticket_bill_bas_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_ticket_bill_bas_inf(
         |bill_id                     string,
         |bill_nm                     string,
         |bill_desc                   string,
         |bill_tp                     string,
         |mchnt_cd                    string,
         |mchnt_nm                    string,
         |affl_id                     string,
         |affl_nm                     string,
         |bill_pic_path               string,
         |acpt_in                     string,
         |enable_in                   string,
         |dwn_total_num               bigint,
         |dwn_num                     bigint,
         |valid_begin_dt              timestamp,
         |valid_end_dt                timestamp,
         |dwn_num_limit               bigint,
         |disc_rate                   int,
         |money_at                    int,
         |low_trans_at_limit          bigint,
         |high_trans_at_limit         bigint,
         |sale_in                     string,
         |bill_price                  bigint,
         |bill_st                     string,
         |oper_action                 string,
         |aud_st                      string,
         |aud_usr_id                  string,
         |aud_ts                      timestamp,
         |aud_idea                    string,
         |rec_upd_usr_id              string,
         |rec_upd_ts                  timestamp,
         |rec_crt_usr_id              string ,
         |rec_crt_ts                  timestamp,
         |ver_no                      int ,
         |bill_related_card_bin       string,
         |event_id                    string,
         |oper_in                     string,
         |sync_st                     string,
         |blkbill_in                  string,
         |chara_grp_cd                string,
         |chara_grp_nm                string,
         |obtain_chnl                 string,
         |cfg_tp                      string,
         |delay_use_days              int   ,
         |bill_rule_bmp               string,
         |cup_branch_ins_id_cd        string,
         |cycle_deduct_in             string,
         |discount_at_max             bigint,
         |input_data_tp               string,
         |temp_use_in                 string,
         |aud_id                      bigint,
         |entry_ins_id_cd             string,
         |entry_ins_cn_nm             string,
         |entry_cup_branch_ins_id_cd  string,
         |entry_cup_branch_nm         string,
         |exclusive_in                string,
         |data_src                    string,
         |bill_original_price         bigint,
         |price_trend_st              string,
         |bill_sub_tp                 string,
         |pay_timeout                 int ,
         |auto_refund_st              string,
         |anytime_refund_st           string,
         |imprest_tp_st               string,
         |rand_tp                     string,
         |expt_val                    int,
         |std_deviation               int,
         |rand_at_min                 int,
         |rand_at_max                 int,
         |disc_max_in                 string,
         |disc_max                    int,
         |rand_period_tp              string,
         |rand_period                 string,
         |cup_branch_ins_id_nm        string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_ticket_bill_bas_inf successfully ! =======")

  }

  def hive_undefine_store_inf (implicit sqlContext: HiveContext) = {
    println("=======Create hive_undefine_store_inf=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_undefine_store_inf(
         |mchnt_cd          	string,
         |term_id             string,
         |store_cd            string,
         |store_grp_cd        string,
         |brand_id            bigint
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_undefine_store_inf successfully ! =======")

  }

  def hive_use_td_d (implicit sqlContext: HiveContext) = {
    println("=======Create hive_use_td_d=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.hive_use_td_d(
         |tduser_id		string,
         |relate_id   string,
         |start_int   bigint,
         |end_int     bigint,
         |start_dt    timestamp,
         |end_dt      timestamp
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create hive_use_td_d successfully ! =======")

  }

  def HIVE_BILL_ORDER_TRANS (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_BILL_ORDER_TRANS=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         create table if not exists $hive_dbname.HIVE_BILL_ORDER_TRANS
         |(
         |BILL_ORDER_ID          string,
         |MCHNT_CD               string,
         |MCHNT_NM               string,
         |SUB_MCHNT_CD           string,
         |CDHD_USR_ID            string,
         |SUB_MCHNT_NM           string,
         |RELATED_USR_ID         bigint,
         |CUPS_TRACE_NUMBER      string,
         |TRANS_TM               string,
         |TRANS_DT               timestamp,
         |ORIG_TRANS_SEQ         string,
         |TRANS_SEQ              string,
         |MOBILE_ORDER_ID        string,
         |ACP_ORDER_ID           string,
         |DELIVERY_PROV_CD       string,
         |DELIVERY_CITY_CD       string,
         |DELIVERY_DISTRICT_NM   string,
         |DELIVERY_DISTRICT_CD   string,
         |DELIVERY_ZIP_CD        string,
         |DELIVERY_ADDRESS       string,
         |RECEIVER_NM            string,
         |RECEIVER_MOBILE        string,
         |DELIVERY_TIME_DESC     string,
         |INVOICE_DESC           string,
         |TRANS_AT               bigint,
         |REFUND_AT              bigint,
         |ORDER_ST               string,
         |ORDER_CRT_TS           timestamp,
         |ORDER_TIMEOUT_TS       timestamp,
         |CARD_NO                string,
         |ORDER_CHNL             string,
         |ORDER_IP               string,
         |DEVICE_INF             string,
         |REMARK                 string,
         |REC_CRT_TS             timestamp,
         |CRT_CDHD_USR_ID        string,
         |REC_UPD_TS             timestamp,
         |UPD_CDHD_USR_ID        string
         |)
         |partitioned by(part_trans_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_BILL_ORDER_TRANS successfully ! =======")

  }

  def HIVE_BILL_SUB_ORDER_TRANS (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_BILL_SUB_ORDER_TRANS=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         create table if not exists $hive_dbname.HIVE_BILL_SUB_ORDER_TRANS(
         |BILL_SUB_ORDER_ID    BIGINT          comment '票券子订单编号  ',
         |BILL_ORDER_ID        STRING          comment '票券订单编号   ',
         |MCHNT_CD             STRING          comment '商户代码     ',
         |MCHNT_NM             STRING          comment '商户名称     ',
         |SUB_MCHNT_CD         STRING          comment '二级商户号    ',
         |SUB_MCHNT_NM         STRING          comment '二级商户名称   ',
         |BILL_ID              STRING          comment '票券ID     ',
         |BILL_PRICE           BIGINT          comment '票券销售价格   ',
         |TRANS_SEQ            STRING          comment '交易流水号(um)',
         |REFUND_REASON        STRING          comment '退货原因     ',
         |ORDER_ST             STRING          comment '订单状态     ',
         |REC_CRT_TS           TIMESTAMP       comment '记录创建时间   ',
         |CRT_CDHD_USR_ID      STRING          comment '创建用户标识码  ',
         |REC_UPD_TS           TIMESTAMP       comment '记录更新时间   ',
         |UPD_CDHD_USR_ID      STRING          comment '修改用户标识码  ',
         |ORDER_TIMEOUT_TS     TIMESTAMP       comment '订单超时时    ',
         |TRANS_DT             TIMESTAMP       comment '交易日期     ',
         |RELATED_USR_ID       BIGINT          comment '关联用户id   ',
         |TRANS_PROCESS        STRING          comment '订单流水     ',
         |RESPONSE_CODE        STRING          comment '交易应答码-1  ',
         |RESPONSE_MSG         STRING          comment '交易报文     '
         |)
         |partitioned by(part_trans_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_BILL_SUB_ORDER_TRANS successfully ! =======")

  }

  def HIVE_MCHNT_TP (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_MCHNT_TP=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.HIVE_MCHNT_TP(
         |MCHNT_TP          string,
         |MCHNT_TP_GRP      string,
         |MCHNT_TP_DESC_CN  string,
         |MCHNT_TP_DESC_EN  string,
         |REC_ID            int,
         |REC_ST            string,
         |MCC_TYPE          string,
         |LAST_OPER_IN      string,
         |REC_UPD_USR_ID    string,
         |REC_UPD_TS        timestamp,
         |REC_CRT_TS        timestamp,
         |SYNC_ST           string,
         |SYNC_BAT_NO       int,
         |SYNC_TS           timestamp
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_MCHNT_TP successfully ! =======")

  }

  def HIVE_OFFLINE_POINT_TRANS (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_OFFLINE_POINT_TRANS=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.HIVE_OFFLINE_POINT_TRANS(
         |DTL_SEQ                      bigint,
         |CDHD_USR_ID                  string,
         |PRI_ACCT_NO                  string,
         |ACPT_INS_ID_CD               string,
         |FWD_INS_ID_CD                string,
         |SYS_TRA_NO                   string,
         |TFR_DT_TM                    string,
         |CARD_CLASS                   string,
         |CARD_ATTR                    string,
         |CARD_STD                     string,
         |CARD_MEDIA                   string,
         |CUPS_CARD_IN                 string,
         |CUPS_SIG_CARD_IN             string,
         |TRANS_ID                     string,
         |REGION_CD                    string,
         |CARD_BIN                     string,
         |MCHNT_TP                     string,
         |MCHNT_CD                     string,
         |TERM_ID                      string,
         |TRANS_DT                     timestamp,
         |TRANS_TM                     string,
         |SETTLE_DT                    timestamp,
         |SETTLE_AT                    int,
         |TRANS_CHNL                   string,
         |ACPT_TERM_TP                 string,
         |POINT_PLAN_ID                int,
         |PLAN_ID                      int,
         |INS_ACCT_ID                  string,
         |POINT_AT                     bigint,
         |OPER_ST                      string,
         |RULE_ID                      int,
         |PRI_KEY                      string,
         |VER_NO                       int,
         |ACCT_ADDUP_BAT_DT            timestamp,
         |ISS_INS_ID_CD                string,
         |EXTRA_SP_INS_ACCT_ID         string,
         |EXTRA_POINT_AT               bigint,
         |EXTEND_INS_ID_CD             string,
         |CUP_BRANCH_INS_ID_CD         string,
         |CUP_BRANCH_INS_ID_NM         string,
         |UM_TRANS_ID                  string,
         |BUSS_TP                      string,
         |BILL_ID                      string,
         |BILL_NUM                     bigint,
         |OPER_DT                      timestamp,
         |TMP_FLAG                     string,
         |BILL_NM                      string,
         |CHARA_ACCT_TP                string,
         |CHARA_ACCT_NM                string,
         |ACCT_ADDUP_TP                string,
         |REC_CRT_TS                   timestamp,
         |REC_UPD_TS                   timestamp,
         |ORIG_TRANS_SEQ               string,
         |NOTICE_ON_ACCOUNT            string,
         |ORIG_TFR_DT_TM               string,
         |ORIG_SYS_TRA_NO              string,
         |ORIG_ACPT_INS_ID_CD          string,
         |ORIG_FWD_INS_ID_CD           string,
         |INDIRECT_TRANS_IN            string,
         |BOOKING_REC_ID               bigint,
         |BOOKING_IN                   string,
         |PLAN_NM                      string,
         |PLAN_GIVE_TOTAL_NUM          bigint,
         |PLAN_GIVE_LIMIT_TP           string,
         |PLAN_GIVE_LIMIT              int,
         |DAY_GIVE_LIMIT               int,
         |GIVE_LIMIT_IN                string,
         |RETRI_REF_NO                 string
         |)
         |partitioned by(part_trans_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_OFFLINE_POINT_TRANS successfully ! =======")

  }

  def HIVE_ONLINE_POINT_TRANS (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_ONLINE_POINT_TRANS=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.HIVE_ONLINE_POINT_TRANS(
         |TRANS_ID                     bigint,
         |CDHD_USR_ID                  string,
         |TRANS_TP                     string,
         |BUSS_TP                      string,
         |TRANS_POINT_AT               bigint,
         |CHARA_ACCT_TP                string,
         |BILL_ID                      string,
         |BILL_NUM                     bigint,
         |TRANS_DT                     timestamp,
         |TRANS_TM                     string,
         |VENDOR_ID                    string,
         |REMARK                       string,
         |CARD_NO                      string,
         |STATUS                       string,
         |TERM_TRANS_SEQ               string,
         |ORIG_TERM_TRANS_SEQ          string,
         |MCHNT_CD                     string,
         |TERM_ID                      string,
         |REFUND_TS                    timestamp,
         |ORDER_TP                     string,
         |TRANS_AT                     bigint,
         |SVC_ORDER_ID                 string,
         |TRANS_DTL                    string,
         |EXCH_RATE                    bigint,
         |DISC_AT_POINT                bigint,
         |CDHD_FK                      string,
         |BILL_NM                      string,
         |CHARA_ACCT_NM                string,
         |REC_CRT_TS                   timestamp,
         |TRANS_SEQ                    string,
         |SYS_ERR_CD                   string,
         |BILL_ACQ_MD                  string,
         |CUP_BRANCH_INS_ID_CD         string,
         |CUP_BRANCH_INS_ID_NM         string
         |)
         |partitioned by(part_trans_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_ONLINE_POINT_TRANS successfully ! =======")

  }

  def HIVE_PRIZE_ACTIVITY_BAS_INF (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_PRIZE_ACTIVITY_BAS_INF=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.HIVE_PRIZE_ACTIVITY_BAS_INF
         |(
         |LOC_ACTIVITY_ID        int,
         |ACTIVITY_PLAT          string,
         |LOC_ACTIVITY_NM        string,
         |LOC_ACTIVITY_DESC      string,
         |ACTIVITY_BEGIN_DT      TIMESTAMP,
         |ACTIVITY_END_DT        TIMESTAMP,
         |WEEK_TM_BMP            string,
         |CHECK_ST               string,
         |SYNC_ST                string,
         |SYNC_BAT_NO            int,
         |RUN_ST                 string,
         |OPER_IN                string,
         |EVENT_ID               int,
         |REC_ID                 int,
         |REC_UPD_USR_ID         string,
         |REC_UPD_TS             timestamp,
         |REC_CRT_TS             timestamp,
         |REC_CRT_USR_ID         string,
         |DEL_IN                 string,
         |AUD_USR_ID             string,
         |AUD_TS                 timestamp,
         |AUD_IDEA               string,
         |ACTIVITY_ST            string,
         |LOC_ACTIVITY_CRT_INS   string,
         |CUP_BRANCH_INS_ID_NM   string,
         |VER_NO                 int,
         |ACTIVITY_TP            string,
         |REPRIZE_LIMIT          string,
         |SMS_FLAG               string,
         |CASHIER_REWARD_IN      string,
         |MCHNT_CD               string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_PRIZE_ACTIVITY_BAS_INF successfully ! =======")

  }

  def HIVE_PRIZE_DISCOUNT_RESULT (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_PRIZE_DISCOUNT_RESULT=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.HIVE_PRIZE_DISCOUNT_RESULT
         |(
         |PRIZE_RESULT_SEQ       INT,
         |TRANS_ID               string,
         |SYS_TRA_NO             string,
         |SYS_TRA_NO_CONV        string,
         |PRI_ACCT_NO            string,
         |TRANS_AT               INT,
         |TRANS_AT_CONV          INT,
         |TRANS_POS_AT           INT,
         |TRANS_DT_TM            string,
         |LOC_TRANS_DT           string,
         |LOC_TRANS_TM           string,
         |SETTLE_DT              timestamp,
         |MCHNT_TP               string,
         |ACPT_INS_ID_CD         string,
         |ISS_INS_ID_CD          string,
         |ACQ_INS_ID_CD          string,
         |CUP_BRANCH_INS_ID_CD   string,
         |CUP_BRANCH_INS_ID_NM   string,
         |MCHNT_CD               string,
         |TERM_ID                string,
         |TRANS_CURR_CD          string,
         |TRANS_CHNL             string,
         |PROD_IN                string,
         |AGIO_APP_ID            string,
         |AGIO_INF               string,
         |PRIZE_APP_ID           string,
         |PRIZE_ID               string,
         |PRIZE_LVL              string,
         |REC_CRT_DT             timestamp,
         |IS_MATCH_IN            string,
         |FWD_INS_ID_CD          string,
         |ORIG_TRANS_TFR_TM      string,
         |ORIG_SYS_TRA_NO        string,
         |ORIG_ACPT_INS_ID_CD    string,
         |ORIG_FWD_INS_ID_CD     string,
         |SUB_CARD_NO            string,
         |IS_PROCED              string,
         |ENTITY_CARD_NO         string,
         |CLOUD_PAY_IN           string,
         |CARD_MEDIA             string
         |)
         |partitioned by(part_settle_dt string)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_PRIZE_DISCOUNT_RESULT successfully ! =======")

  }

  def HIVE_PRIZE_LVL_ADD_RULE (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_PRIZE_LVL_ADD_RULE=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.HIVE_PRIZE_LVL_ADD_RULE
         |(
         |LOC_ACTIVITY_ID    int,
         |ACTIVITY_PLAT      int,
         |LOC_ACTIVITY_NM    bigint,
         |LOC_ACTIVITY_DESC  bigint,
         |ACTIVITY_BEGIN_DT  string,
         |ACTIVITY_END_DT    int,
         |WEEK_TM_BMP        string,
         |CHECK_ST           string,
         |SYNC_ST            bigint,
         |SYNC_BAT_NO        bigint,
         |RUN_ST             bigint,
         |OPER_IN            string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_PRIZE_LVL_ADD_RULE successfully ! =======")

  }

  def HIVE_PRIZE_LVL (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_PRIZE_LVL=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.HIVE_PRIZE_LVL
         |(
         |LOC_ACTIVITY_ID      int,
         |PRIZE_TP             string,
         |PRIZE_LVL            int,
         |PRIZE_ID_LVL         int,
         |ACTIVITY_PLAT        string,
         |PRIZE_ID             int,
         |RUN_ST               string,
         |SYNC_ST              string,
         |SYNC_BAT_NO          int,
         |LVL_PRIZE_NUM        int,
         |PRIZE_LVL_DESC       string,
         |REPRIZE_LIMIT        string,
         |PRIZE_PAY_TP         string,
         |CYCLE_PRIZE_NUM      int,
         |CYCLE_SPAN           int,
         |CYCLE_UNIT           string,
         |PROGRS_IN            string,
         |SEG_PRIZE_NUM        int,
         |MIN_PRIZE_TRANS_AT   bigint,
         |MAX_PRIZE_TRANS_AT   bigint,
         |PRIZE_AT             bigint,
         |OPER_IN              string,
         |EVENT_ID             int,
         |REC_ID               int,
         |REC_UPD_USR_ID       string,
         |REC_UPD_TS           timestamp,
         |REC_CRT_TS           timestamp,
         |VER_NO               int
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_PRIZE_LVL successfully ! =======")

  }

  def HIVE_STORE_TERM_RELATION (implicit sqlContext: HiveContext) = {
    println("=======Create HIVE_STORE_TERM_RELATION=======")
    sqlContext.sql(s"use $hive_dbname")
    sqlContext.sql(
      s"""
         |create table if not exists $hive_dbname.HIVE_STORE_TERM_RELATION(
         |REC_ID                bigint,
         |MCHNT_CD              string,
         |TERM_ID               string,
         |THIRD_PARTY_INS_FK    int,
         |REC_UPD_USR_ID        string,
         |REC_UPD_TS            timestamp,
         |REC_CRT_USR_ID        string,
         |REC_CRT_TS            timestamp,
         |THIRD_PARTY_INS_ID    string,
         |IS_TRANS_TP           string
         |)
         |row format delimited fields terminated by '!|'
         |stored as parquet
         | """.stripMargin)

    println("=======Create HIVE_STORE_TERM_RELATION successfully ! =======")

  }

}
