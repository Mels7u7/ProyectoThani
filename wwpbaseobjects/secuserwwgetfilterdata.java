package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secuserwwgetfilterdata extends GXProcedure
{
   public secuserwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuserwwgetfilterdata.class ), "" );
   }

   public secuserwwgetfilterdata( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      secuserwwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      secuserwwgetfilterdata.this.AV16DDOName = aP0;
      secuserwwgetfilterdata.this.AV14SearchTxt = aP1;
      secuserwwgetfilterdata.this.AV15SearchTxtTo = aP2;
      secuserwwgetfilterdata.this.aP3 = aP3;
      secuserwwgetfilterdata.this.aP4 = aP4;
      secuserwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser", GXv_boolean2) ;
      secuserwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV43WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV43WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECUSERNAME") == 0 )
         {
            /* Execute user subroutine: 'LOADSECUSERNAMEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECUSERPASSWORD") == 0 )
         {
            /* Execute user subroutine: 'LOADSECUSERPASSWORDOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECUSEREMAIL") == 0 )
         {
            /* Execute user subroutine: 'LOADSECUSEREMAILOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV20OptionsJson = AV19Options.toJSonString(false) ;
      AV23OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV25OptionIndexesJson = AV24OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue("WWPBaseObjects.SecUserWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecUserWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("WWPBaseObjects.SecUserWWGridState"), null, null);
      }
      AV53GXV1 = 1 ;
      while ( AV53GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV53GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV44FilterFullText = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV10TFSecUserId = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV11TFSecUserId_To = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME") == 0 )
         {
            AV12TFSecUserName = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME_SEL") == 0 )
         {
            AV13TFSecUserName_Sel = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPASSWORD") == 0 )
         {
            AV45TFSecUserPassword = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPASSWORD_SEL") == 0 )
         {
            AV46TFSecUserPassword_Sel = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSEREMAIL") == 0 )
         {
            AV47TFSecUserEmail = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSEREMAIL_SEL") == 0 )
         {
            AV48TFSecUserEmail_Sel = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERESTADOR_SEL") == 0 )
         {
            AV49TFSecUserEstadoR_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFSecUserEstadoR_Sels.fromJSonString(AV49TFSecUserEstadoR_SelsJson, null);
         }
         AV53GXV1 = (int)(AV53GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECUSERNAMEOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSecUserName = AV14SearchTxt ;
      AV13TFSecUserName_Sel = "" ;
      AV55Wwpbaseobjects_secuserwwds_1_filterfulltext = AV44FilterFullText ;
      AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid = AV10TFSecUserId ;
      AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to = AV11TFSecUserId_To ;
      AV58Wwpbaseobjects_secuserwwds_4_tfsecusername = AV12TFSecUserName ;
      AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel = AV13TFSecUserName_Sel ;
      AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = AV45TFSecUserPassword ;
      AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel = AV46TFSecUserPassword_Sel ;
      AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail = AV47TFSecUserEmail ;
      AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel = AV48TFSecUserEmail_Sel ;
      AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels = AV50TFSecUserEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A211SecUserEstadoR ,
                                           AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                           AV55Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                           Short.valueOf(AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid) ,
                                           Short.valueOf(AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) ,
                                           AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                           AV58Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                           AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                           AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                           AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                           AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                           Integer.valueOf(AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels.size()) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           A15SecUserPassword ,
                                           A122SecUserEmail } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV58Wwpbaseobjects_secuserwwds_4_tfsecusername = GXutil.concat( GXutil.rtrim( AV58Wwpbaseobjects_secuserwwds_4_tfsecusername), "%", "") ;
      lV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword), "%", "") ;
      lV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail = GXutil.concat( GXutil.rtrim( AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail), "%", "") ;
      /* Using cursor P002B2 */
      pr_default.execute(0, new Object[] {lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, Short.valueOf(AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid), Short.valueOf(AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to), lV58Wwpbaseobjects_secuserwwds_4_tfsecusername, AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel, lV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword, AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel, lV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail, AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2B2 = false ;
         A14SecUserName = P002B2_A14SecUserName[0] ;
         A6SecUserId = P002B2_A6SecUserId[0] ;
         A211SecUserEstadoR = P002B2_A211SecUserEstadoR[0] ;
         A122SecUserEmail = P002B2_A122SecUserEmail[0] ;
         A15SecUserPassword = P002B2_A15SecUserPassword[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P002B2_A14SecUserName[0], A14SecUserName) == 0 ) )
         {
            brk2B2 = false ;
            A6SecUserId = P002B2_A6SecUserId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk2B2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A14SecUserName)==0) )
         {
            AV18Option = A14SecUserName ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2B2 )
         {
            brk2B2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECUSERPASSWORDOPTIONS' Routine */
      returnInSub = false ;
      AV45TFSecUserPassword = AV14SearchTxt ;
      AV46TFSecUserPassword_Sel = "" ;
      AV55Wwpbaseobjects_secuserwwds_1_filterfulltext = AV44FilterFullText ;
      AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid = AV10TFSecUserId ;
      AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to = AV11TFSecUserId_To ;
      AV58Wwpbaseobjects_secuserwwds_4_tfsecusername = AV12TFSecUserName ;
      AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel = AV13TFSecUserName_Sel ;
      AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = AV45TFSecUserPassword ;
      AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel = AV46TFSecUserPassword_Sel ;
      AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail = AV47TFSecUserEmail ;
      AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel = AV48TFSecUserEmail_Sel ;
      AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels = AV50TFSecUserEstadoR_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A211SecUserEstadoR ,
                                           AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                           AV55Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                           Short.valueOf(AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid) ,
                                           Short.valueOf(AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) ,
                                           AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                           AV58Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                           AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                           AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                           AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                           AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                           Integer.valueOf(AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels.size()) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           A15SecUserPassword ,
                                           A122SecUserEmail } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV58Wwpbaseobjects_secuserwwds_4_tfsecusername = GXutil.concat( GXutil.rtrim( AV58Wwpbaseobjects_secuserwwds_4_tfsecusername), "%", "") ;
      lV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword), "%", "") ;
      lV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail = GXutil.concat( GXutil.rtrim( AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail), "%", "") ;
      /* Using cursor P002B3 */
      pr_default.execute(1, new Object[] {lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, Short.valueOf(AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid), Short.valueOf(AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to), lV58Wwpbaseobjects_secuserwwds_4_tfsecusername, AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel, lV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword, AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel, lV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail, AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2B4 = false ;
         A15SecUserPassword = P002B3_A15SecUserPassword[0] ;
         A6SecUserId = P002B3_A6SecUserId[0] ;
         A211SecUserEstadoR = P002B3_A211SecUserEstadoR[0] ;
         A122SecUserEmail = P002B3_A122SecUserEmail[0] ;
         A14SecUserName = P002B3_A14SecUserName[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P002B3_A15SecUserPassword[0], A15SecUserPassword) == 0 ) )
         {
            brk2B4 = false ;
            A6SecUserId = P002B3_A6SecUserId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk2B4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A15SecUserPassword)==0) )
         {
            AV18Option = A15SecUserPassword ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2B4 )
         {
            brk2B4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADSECUSEREMAILOPTIONS' Routine */
      returnInSub = false ;
      AV47TFSecUserEmail = AV14SearchTxt ;
      AV48TFSecUserEmail_Sel = "" ;
      AV55Wwpbaseobjects_secuserwwds_1_filterfulltext = AV44FilterFullText ;
      AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid = AV10TFSecUserId ;
      AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to = AV11TFSecUserId_To ;
      AV58Wwpbaseobjects_secuserwwds_4_tfsecusername = AV12TFSecUserName ;
      AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel = AV13TFSecUserName_Sel ;
      AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = AV45TFSecUserPassword ;
      AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel = AV46TFSecUserPassword_Sel ;
      AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail = AV47TFSecUserEmail ;
      AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel = AV48TFSecUserEmail_Sel ;
      AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels = AV50TFSecUserEstadoR_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A211SecUserEstadoR ,
                                           AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                           AV55Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                           Short.valueOf(AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid) ,
                                           Short.valueOf(AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) ,
                                           AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                           AV58Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                           AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                           AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                           AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                           AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                           Integer.valueOf(AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels.size()) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           A15SecUserPassword ,
                                           A122SecUserEmail } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV58Wwpbaseobjects_secuserwwds_4_tfsecusername = GXutil.concat( GXutil.rtrim( AV58Wwpbaseobjects_secuserwwds_4_tfsecusername), "%", "") ;
      lV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword), "%", "") ;
      lV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail = GXutil.concat( GXutil.rtrim( AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail), "%", "") ;
      /* Using cursor P002B4 */
      pr_default.execute(2, new Object[] {lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, lV55Wwpbaseobjects_secuserwwds_1_filterfulltext, Short.valueOf(AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid), Short.valueOf(AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to), lV58Wwpbaseobjects_secuserwwds_4_tfsecusername, AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel, lV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword, AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel, lV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail, AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk2B6 = false ;
         A122SecUserEmail = P002B4_A122SecUserEmail[0] ;
         A6SecUserId = P002B4_A6SecUserId[0] ;
         A211SecUserEstadoR = P002B4_A211SecUserEstadoR[0] ;
         A15SecUserPassword = P002B4_A15SecUserPassword[0] ;
         A14SecUserName = P002B4_A14SecUserName[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P002B4_A122SecUserEmail[0], A122SecUserEmail) == 0 ) )
         {
            brk2B6 = false ;
            A6SecUserId = P002B4_A6SecUserId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk2B6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A122SecUserEmail)==0) )
         {
            AV18Option = A122SecUserEmail ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2B6 )
         {
            brk2B6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secuserwwgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = secuserwwgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = secuserwwgetfilterdata.this.AV25OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20OptionsJson = "" ;
      AV23OptionsDescJson = "" ;
      AV25OptionIndexesJson = "" ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV43WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV44FilterFullText = "" ;
      AV12TFSecUserName = "" ;
      AV13TFSecUserName_Sel = "" ;
      AV45TFSecUserPassword = "" ;
      AV46TFSecUserPassword_Sel = "" ;
      AV47TFSecUserEmail = "" ;
      AV48TFSecUserEmail_Sel = "" ;
      AV49TFSecUserEstadoR_SelsJson = "" ;
      AV50TFSecUserEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A14SecUserName = "" ;
      AV55Wwpbaseobjects_secuserwwds_1_filterfulltext = "" ;
      AV58Wwpbaseobjects_secuserwwds_4_tfsecusername = "" ;
      AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel = "" ;
      AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = "" ;
      AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel = "" ;
      AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail = "" ;
      AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel = "" ;
      AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV55Wwpbaseobjects_secuserwwds_1_filterfulltext = "" ;
      lV58Wwpbaseobjects_secuserwwds_4_tfsecusername = "" ;
      lV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = "" ;
      lV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail = "" ;
      A211SecUserEstadoR = "" ;
      A15SecUserPassword = "" ;
      A122SecUserEmail = "" ;
      P002B2_A14SecUserName = new String[] {""} ;
      P002B2_A6SecUserId = new short[1] ;
      P002B2_A211SecUserEstadoR = new String[] {""} ;
      P002B2_A122SecUserEmail = new String[] {""} ;
      P002B2_A15SecUserPassword = new String[] {""} ;
      AV18Option = "" ;
      P002B3_A15SecUserPassword = new String[] {""} ;
      P002B3_A6SecUserId = new short[1] ;
      P002B3_A211SecUserEstadoR = new String[] {""} ;
      P002B3_A122SecUserEmail = new String[] {""} ;
      P002B3_A14SecUserName = new String[] {""} ;
      P002B4_A122SecUserEmail = new String[] {""} ;
      P002B4_A6SecUserId = new short[1] ;
      P002B4_A211SecUserEstadoR = new String[] {""} ;
      P002B4_A15SecUserPassword = new String[] {""} ;
      P002B4_A14SecUserName = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secuserwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P002B2_A14SecUserName, P002B2_A6SecUserId, P002B2_A211SecUserEstadoR, P002B2_A122SecUserEmail, P002B2_A15SecUserPassword
            }
            , new Object[] {
            P002B3_A15SecUserPassword, P002B3_A6SecUserId, P002B3_A211SecUserEstadoR, P002B3_A122SecUserEmail, P002B3_A14SecUserName
            }
            , new Object[] {
            P002B4_A122SecUserEmail, P002B4_A6SecUserId, P002B4_A211SecUserEstadoR, P002B4_A15SecUserPassword, P002B4_A14SecUserName
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10TFSecUserId ;
   private short AV11TFSecUserId_To ;
   private short AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid ;
   private short AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to ;
   private short A6SecUserId ;
   private short Gx_err ;
   private int AV53GXV1 ;
   private int AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size ;
   private long AV26count ;
   private String scmdbuf ;
   private String A211SecUserEstadoR ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk2B2 ;
   private boolean brk2B4 ;
   private boolean brk2B6 ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV49TFSecUserEstadoR_SelsJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV44FilterFullText ;
   private String AV12TFSecUserName ;
   private String AV13TFSecUserName_Sel ;
   private String AV45TFSecUserPassword ;
   private String AV46TFSecUserPassword_Sel ;
   private String AV47TFSecUserEmail ;
   private String AV48TFSecUserEmail_Sel ;
   private String A14SecUserName ;
   private String AV55Wwpbaseobjects_secuserwwds_1_filterfulltext ;
   private String AV58Wwpbaseobjects_secuserwwds_4_tfsecusername ;
   private String AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ;
   private String AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ;
   private String AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ;
   private String AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail ;
   private String AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ;
   private String lV55Wwpbaseobjects_secuserwwds_1_filterfulltext ;
   private String lV58Wwpbaseobjects_secuserwwds_4_tfsecusername ;
   private String lV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ;
   private String lV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail ;
   private String A15SecUserPassword ;
   private String A122SecUserEmail ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P002B2_A14SecUserName ;
   private short[] P002B2_A6SecUserId ;
   private String[] P002B2_A211SecUserEstadoR ;
   private String[] P002B2_A122SecUserEmail ;
   private String[] P002B2_A15SecUserPassword ;
   private String[] P002B3_A15SecUserPassword ;
   private short[] P002B3_A6SecUserId ;
   private String[] P002B3_A211SecUserEstadoR ;
   private String[] P002B3_A122SecUserEmail ;
   private String[] P002B3_A14SecUserName ;
   private String[] P002B4_A122SecUserEmail ;
   private short[] P002B4_A6SecUserId ;
   private String[] P002B4_A211SecUserEstadoR ;
   private String[] P002B4_A15SecUserPassword ;
   private String[] P002B4_A14SecUserName ;
   private GXSimpleCollection<String> AV50TFSecUserEstadoR_Sels ;
   private GXSimpleCollection<String> AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV43WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
}

final  class secuserwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A211SecUserEstadoR ,
                                          GXSimpleCollection<String> AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                          String AV55Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                          short AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid ,
                                          short AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to ,
                                          String AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                          String AV58Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                          String AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                          String AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                          String AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                          String AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                          int AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          String A15SecUserPassword ,
                                          String A122SecUserEmail )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [SecUserName], [SecUserId], [SecUserEstadoR], [SecUserEmail], [SecUserPassword] FROM [SecUser]" ;
      if ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secuserwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([SecUserId] AS decimal(4,0))) like '%' + ?) or ( [SecUserName] like '%' + ?) or ( [SecUserPassword] like '%' + ?) or ( [SecUserEmail] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [SecUserEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [SecUserEstadoR] = 'I'))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (0==AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid) )
      {
         addWhere(sWhereString, "([SecUserId] >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (0==AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) )
      {
         addWhere(sWhereString, "([SecUserId] <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV58Wwpbaseobjects_secuserwwds_4_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "([SecUserName] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserName] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword)==0) ) )
      {
         addWhere(sWhereString, "([SecUserPassword] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserPassword] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) && ( ! (GXutil.strcmp("", AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail)==0) ) )
      {
         addWhere(sWhereString, "([SecUserEmail] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserEmail] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels, "[SecUserEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SecUserName]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002B3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A211SecUserEstadoR ,
                                          GXSimpleCollection<String> AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                          String AV55Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                          short AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid ,
                                          short AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to ,
                                          String AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                          String AV58Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                          String AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                          String AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                          String AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                          String AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                          int AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          String A15SecUserPassword ,
                                          String A122SecUserEmail )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[14];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [SecUserPassword], [SecUserId], [SecUserEstadoR], [SecUserEmail], [SecUserName] FROM [SecUser]" ;
      if ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secuserwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([SecUserId] AS decimal(4,0))) like '%' + ?) or ( [SecUserName] like '%' + ?) or ( [SecUserPassword] like '%' + ?) or ( [SecUserEmail] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [SecUserEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [SecUserEstadoR] = 'I'))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
         GXv_int7[5] = (byte)(1) ;
      }
      if ( ! (0==AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid) )
      {
         addWhere(sWhereString, "([SecUserId] >= ?)");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( ! (0==AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) )
      {
         addWhere(sWhereString, "([SecUserId] <= ?)");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV58Wwpbaseobjects_secuserwwds_4_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "([SecUserName] like ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserName] = ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword)==0) ) )
      {
         addWhere(sWhereString, "([SecUserPassword] like ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserPassword] = ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) && ( ! (GXutil.strcmp("", AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail)==0) ) )
      {
         addWhere(sWhereString, "([SecUserEmail] like ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserEmail] = ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels, "[SecUserEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SecUserPassword]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P002B4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A211SecUserEstadoR ,
                                          GXSimpleCollection<String> AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                          String AV55Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                          short AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid ,
                                          short AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to ,
                                          String AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                          String AV58Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                          String AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                          String AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                          String AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                          String AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                          int AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          String A15SecUserPassword ,
                                          String A122SecUserEmail )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [SecUserEmail], [SecUserId], [SecUserEstadoR], [SecUserPassword], [SecUserName] FROM [SecUser]" ;
      if ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secuserwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([SecUserId] AS decimal(4,0))) like '%' + ?) or ( [SecUserName] like '%' + ?) or ( [SecUserPassword] like '%' + ?) or ( [SecUserEmail] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [SecUserEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [SecUserEstadoR] = 'I'))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV56Wwpbaseobjects_secuserwwds_2_tfsecuserid) )
      {
         addWhere(sWhereString, "([SecUserId] >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV57Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) )
      {
         addWhere(sWhereString, "([SecUserId] <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV58Wwpbaseobjects_secuserwwds_4_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "([SecUserName] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserName] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secuserwwds_6_tfsecuserpassword)==0) ) )
      {
         addWhere(sWhereString, "([SecUserPassword] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserPassword] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) && ( ! (GXutil.strcmp("", AV62Wwpbaseobjects_secuserwwds_8_tfsecuseremail)==0) ) )
      {
         addWhere(sWhereString, "([SecUserEmail] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserEmail] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV64Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels, "[SecUserEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SecUserEmail]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P002B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] );
            case 1 :
                  return conditional_P002B3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] );
            case 2 :
                  return conditional_P002B4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002B3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002B4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               return;
      }
   }

}

