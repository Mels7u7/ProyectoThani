package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class logaccesoswwgetfilterdata extends GXProcedure
{
   public logaccesoswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( logaccesoswwgetfilterdata.class ), "" );
   }

   public logaccesoswwgetfilterdata( int remoteHandle ,
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
      logaccesoswwgetfilterdata.this.aP5 = new String[] {""};
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
      logaccesoswwgetfilterdata.this.AV29DDOName = aP0;
      logaccesoswwgetfilterdata.this.AV27SearchTxt = aP1;
      logaccesoswwgetfilterdata.this.AV28SearchTxtTo = aP2;
      logaccesoswwgetfilterdata.this.aP3 = aP3;
      logaccesoswwgetfilterdata.this.aP4 = aP4;
      logaccesoswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV32Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV35OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos", GXv_boolean2) ;
      logaccesoswwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_SECUSERNAME") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_SECROLEDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECROLEDESCRIPTIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_LOGACCESOSFULLNAME") == 0 )
         {
            /* Execute user subroutine: 'LOADLOGACCESOSFULLNAMEOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV33OptionsJson = AV32Options.toJSonString(false) ;
      AV36OptionsDescJson = AV35OptionsDesc.toJSonString(false) ;
      AV38OptionIndexesJson = AV37OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV40Session.getValue("LogAccesosWWGridState"), "") == 0 )
      {
         AV42GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LogAccesosWWGridState"), null, null);
      }
      else
      {
         AV42GridState.fromxml(AV40Session.getValue("LogAccesosWWGridState"), null, null);
      }
      AV48GXV1 = 1 ;
      while ( AV48GXV1 <= AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV43GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV48GXV1));
         if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV45FilterFullText = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSID") == 0 )
         {
            AV11TFLogAccesosId = (short)(GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFLogAccesosId_To = (short)(GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV13TFSecUserId = (short)(GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFSecUserId_To = (short)(GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME") == 0 )
         {
            AV15TFSecUserName = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME_SEL") == 0 )
         {
            AV16TFSecUserName_Sel = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEID") == 0 )
         {
            AV17TFSecRoleId = (short)(GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV18TFSecRoleId_To = (short)(GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV19TFSecRoleDescription = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV20TFSecRoleDescription_Sel = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFULLNAME") == 0 )
         {
            AV21TFLogAccesosFullName = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFULLNAME_SEL") == 0 )
         {
            AV22TFLogAccesosFullName_Sel = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSTIPO_SEL") == 0 )
         {
            AV23TFLogAccesosTipo_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFLogAccesosTipo_Sels.fromJSonString(AV23TFLogAccesosTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFECHA") == 0 )
         {
            AV25TFLogAccesosFecha = localUtil.ctot( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV26TFLogAccesosFecha_To = localUtil.ctot( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         AV48GXV1 = (int)(AV48GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECUSERNAMEOPTIONS' Routine */
      returnInSub = false ;
      AV15TFSecUserName = AV27SearchTxt ;
      AV16TFSecUserName_Sel = "" ;
      AV50Logaccesoswwds_1_filterfulltext = AV45FilterFullText ;
      AV51Logaccesoswwds_2_tflogaccesosid = AV11TFLogAccesosId ;
      AV52Logaccesoswwds_3_tflogaccesosid_to = AV12TFLogAccesosId_To ;
      AV53Logaccesoswwds_4_tfsecuserid = AV13TFSecUserId ;
      AV54Logaccesoswwds_5_tfsecuserid_to = AV14TFSecUserId_To ;
      AV55Logaccesoswwds_6_tfsecusername = AV15TFSecUserName ;
      AV56Logaccesoswwds_7_tfsecusername_sel = AV16TFSecUserName_Sel ;
      AV57Logaccesoswwds_8_tfsecroleid = AV17TFSecRoleId ;
      AV58Logaccesoswwds_9_tfsecroleid_to = AV18TFSecRoleId_To ;
      AV59Logaccesoswwds_10_tfsecroledescription = AV19TFSecRoleDescription ;
      AV60Logaccesoswwds_11_tfsecroledescription_sel = AV20TFSecRoleDescription_Sel ;
      AV61Logaccesoswwds_12_tflogaccesosfullname = AV21TFLogAccesosFullName ;
      AV62Logaccesoswwds_13_tflogaccesosfullname_sel = AV22TFLogAccesosFullName_Sel ;
      AV63Logaccesoswwds_14_tflogaccesostipo_sels = AV24TFLogAccesosTipo_Sels ;
      AV64Logaccesoswwds_15_tflogaccesosfecha = AV25TFLogAccesosFecha ;
      AV65Logaccesoswwds_16_tflogaccesosfecha_to = AV26TFLogAccesosFecha_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A227LogAccesosTipo ,
                                           AV63Logaccesoswwds_14_tflogaccesostipo_sels ,
                                           Short.valueOf(AV51Logaccesoswwds_2_tflogaccesosid) ,
                                           Short.valueOf(AV52Logaccesoswwds_3_tflogaccesosid_to) ,
                                           Short.valueOf(AV53Logaccesoswwds_4_tfsecuserid) ,
                                           Short.valueOf(AV54Logaccesoswwds_5_tfsecuserid_to) ,
                                           AV56Logaccesoswwds_7_tfsecusername_sel ,
                                           AV55Logaccesoswwds_6_tfsecusername ,
                                           Short.valueOf(AV57Logaccesoswwds_8_tfsecroleid) ,
                                           Short.valueOf(AV58Logaccesoswwds_9_tfsecroleid_to) ,
                                           AV60Logaccesoswwds_11_tfsecroledescription_sel ,
                                           AV59Logaccesoswwds_10_tfsecroledescription ,
                                           Integer.valueOf(AV63Logaccesoswwds_14_tflogaccesostipo_sels.size()) ,
                                           AV64Logaccesoswwds_15_tflogaccesosfecha ,
                                           AV65Logaccesoswwds_16_tflogaccesosfecha_to ,
                                           Short.valueOf(A41LogAccesosId) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           Short.valueOf(A4SecRoleId) ,
                                           A12SecRoleDescription ,
                                           A228LogAccesosFecha ,
                                           AV50Logaccesoswwds_1_filterfulltext ,
                                           A172LogAccesosFullName ,
                                           AV62Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                           AV61Logaccesoswwds_12_tflogaccesosfullname } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV55Logaccesoswwds_6_tfsecusername = GXutil.concat( GXutil.rtrim( AV55Logaccesoswwds_6_tfsecusername), "%", "") ;
      lV59Logaccesoswwds_10_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV59Logaccesoswwds_10_tfsecroledescription), "%", "") ;
      /* Using cursor P00382 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV51Logaccesoswwds_2_tflogaccesosid), Short.valueOf(AV52Logaccesoswwds_3_tflogaccesosid_to), Short.valueOf(AV53Logaccesoswwds_4_tfsecuserid), Short.valueOf(AV54Logaccesoswwds_5_tfsecuserid_to), lV55Logaccesoswwds_6_tfsecusername, AV56Logaccesoswwds_7_tfsecusername_sel, Short.valueOf(AV57Logaccesoswwds_8_tfsecroleid), Short.valueOf(AV58Logaccesoswwds_9_tfsecroleid_to), lV59Logaccesoswwds_10_tfsecroledescription, AV60Logaccesoswwds_11_tfsecroledescription_sel, AV64Logaccesoswwds_15_tflogaccesosfecha, AV65Logaccesoswwds_16_tflogaccesosfecha_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk382 = false ;
         A228LogAccesosFecha = P00382_A228LogAccesosFecha[0] ;
         A6SecUserId = P00382_A6SecUserId[0] ;
         A41LogAccesosId = P00382_A41LogAccesosId[0] ;
         A227LogAccesosTipo = P00382_A227LogAccesosTipo[0] ;
         A12SecRoleDescription = P00382_A12SecRoleDescription[0] ;
         A14SecUserName = P00382_A14SecUserName[0] ;
         A4SecRoleId = P00382_A4SecRoleId[0] ;
         A14SecUserName = P00382_A14SecUserName[0] ;
         A12SecRoleDescription = P00382_A12SecRoleDescription[0] ;
         GXt_char4 = A172LogAccesosFullName ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char5) ;
         logaccesoswwgetfilterdata.this.GXt_char4 = GXv_char5[0] ;
         A172LogAccesosFullName = GXt_char4 ;
         if ( (GXutil.strcmp("", AV50Logaccesoswwds_1_filterfulltext)==0) || ( ( GXutil.like( GXutil.str( A41LogAccesosId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A6SecUserId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A14SecUserName , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A4SecRoleId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A12SecRoleDescription , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 120 , "%"),  ' ' ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( "ingreso" , GXutil.padr( "%" + GXutil.lower( AV50Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) ) || ( GXutil.like( "salida" , GXutil.padr( "%" + GXutil.lower( AV50Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) ) )
         {
            if ( ! ( (GXutil.strcmp("", AV62Logaccesoswwds_13_tflogaccesosfullname_sel)==0) && ( ! (GXutil.strcmp("", AV61Logaccesoswwds_12_tflogaccesosfullname)==0) ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( AV61Logaccesoswwds_12_tflogaccesosfullname , 100 , "%"),  ' ' ) ) )
            {
               if ( (GXutil.strcmp("", AV62Logaccesoswwds_13_tflogaccesosfullname_sel)==0) || ( ( GXutil.strcmp(A172LogAccesosFullName, AV62Logaccesoswwds_13_tflogaccesosfullname_sel) == 0 ) ) )
               {
                  AV39count = 0 ;
                  while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00382_A14SecUserName[0], A14SecUserName) == 0 ) )
                  {
                     brk382 = false ;
                     A6SecUserId = P00382_A6SecUserId[0] ;
                     A41LogAccesosId = P00382_A41LogAccesosId[0] ;
                     AV39count = (long)(AV39count+1) ;
                     brk382 = true ;
                     pr_default.readNext(0);
                  }
                  if ( ! (GXutil.strcmp("", A14SecUserName)==0) )
                  {
                     AV31Option = A14SecUserName ;
                     AV32Options.add(AV31Option, 0);
                     AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV39count), "Z,ZZZ,ZZZ,ZZ9")), 0);
                  }
                  if ( AV32Options.size() == 50 )
                  {
                     /* Exit For each command. Update data (if necessary), close cursors & exit. */
                     if (true) break;
                  }
               }
            }
         }
         if ( ! brk382 )
         {
            brk382 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECROLEDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV19TFSecRoleDescription = AV27SearchTxt ;
      AV20TFSecRoleDescription_Sel = "" ;
      AV50Logaccesoswwds_1_filterfulltext = AV45FilterFullText ;
      AV51Logaccesoswwds_2_tflogaccesosid = AV11TFLogAccesosId ;
      AV52Logaccesoswwds_3_tflogaccesosid_to = AV12TFLogAccesosId_To ;
      AV53Logaccesoswwds_4_tfsecuserid = AV13TFSecUserId ;
      AV54Logaccesoswwds_5_tfsecuserid_to = AV14TFSecUserId_To ;
      AV55Logaccesoswwds_6_tfsecusername = AV15TFSecUserName ;
      AV56Logaccesoswwds_7_tfsecusername_sel = AV16TFSecUserName_Sel ;
      AV57Logaccesoswwds_8_tfsecroleid = AV17TFSecRoleId ;
      AV58Logaccesoswwds_9_tfsecroleid_to = AV18TFSecRoleId_To ;
      AV59Logaccesoswwds_10_tfsecroledescription = AV19TFSecRoleDescription ;
      AV60Logaccesoswwds_11_tfsecroledescription_sel = AV20TFSecRoleDescription_Sel ;
      AV61Logaccesoswwds_12_tflogaccesosfullname = AV21TFLogAccesosFullName ;
      AV62Logaccesoswwds_13_tflogaccesosfullname_sel = AV22TFLogAccesosFullName_Sel ;
      AV63Logaccesoswwds_14_tflogaccesostipo_sels = AV24TFLogAccesosTipo_Sels ;
      AV64Logaccesoswwds_15_tflogaccesosfecha = AV25TFLogAccesosFecha ;
      AV65Logaccesoswwds_16_tflogaccesosfecha_to = AV26TFLogAccesosFecha_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A227LogAccesosTipo ,
                                           AV63Logaccesoswwds_14_tflogaccesostipo_sels ,
                                           Short.valueOf(AV51Logaccesoswwds_2_tflogaccesosid) ,
                                           Short.valueOf(AV52Logaccesoswwds_3_tflogaccesosid_to) ,
                                           Short.valueOf(AV53Logaccesoswwds_4_tfsecuserid) ,
                                           Short.valueOf(AV54Logaccesoswwds_5_tfsecuserid_to) ,
                                           AV56Logaccesoswwds_7_tfsecusername_sel ,
                                           AV55Logaccesoswwds_6_tfsecusername ,
                                           Short.valueOf(AV57Logaccesoswwds_8_tfsecroleid) ,
                                           Short.valueOf(AV58Logaccesoswwds_9_tfsecroleid_to) ,
                                           AV60Logaccesoswwds_11_tfsecroledescription_sel ,
                                           AV59Logaccesoswwds_10_tfsecroledescription ,
                                           Integer.valueOf(AV63Logaccesoswwds_14_tflogaccesostipo_sels.size()) ,
                                           AV64Logaccesoswwds_15_tflogaccesosfecha ,
                                           AV65Logaccesoswwds_16_tflogaccesosfecha_to ,
                                           Short.valueOf(A41LogAccesosId) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           Short.valueOf(A4SecRoleId) ,
                                           A12SecRoleDescription ,
                                           A228LogAccesosFecha ,
                                           AV50Logaccesoswwds_1_filterfulltext ,
                                           A172LogAccesosFullName ,
                                           AV62Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                           AV61Logaccesoswwds_12_tflogaccesosfullname } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV55Logaccesoswwds_6_tfsecusername = GXutil.concat( GXutil.rtrim( AV55Logaccesoswwds_6_tfsecusername), "%", "") ;
      lV59Logaccesoswwds_10_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV59Logaccesoswwds_10_tfsecroledescription), "%", "") ;
      /* Using cursor P00383 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV51Logaccesoswwds_2_tflogaccesosid), Short.valueOf(AV52Logaccesoswwds_3_tflogaccesosid_to), Short.valueOf(AV53Logaccesoswwds_4_tfsecuserid), Short.valueOf(AV54Logaccesoswwds_5_tfsecuserid_to), lV55Logaccesoswwds_6_tfsecusername, AV56Logaccesoswwds_7_tfsecusername_sel, Short.valueOf(AV57Logaccesoswwds_8_tfsecroleid), Short.valueOf(AV58Logaccesoswwds_9_tfsecroleid_to), lV59Logaccesoswwds_10_tfsecroledescription, AV60Logaccesoswwds_11_tfsecroledescription_sel, AV64Logaccesoswwds_15_tflogaccesosfecha, AV65Logaccesoswwds_16_tflogaccesosfecha_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk384 = false ;
         A12SecRoleDescription = P00383_A12SecRoleDescription[0] ;
         A228LogAccesosFecha = P00383_A228LogAccesosFecha[0] ;
         A6SecUserId = P00383_A6SecUserId[0] ;
         A41LogAccesosId = P00383_A41LogAccesosId[0] ;
         A227LogAccesosTipo = P00383_A227LogAccesosTipo[0] ;
         A14SecUserName = P00383_A14SecUserName[0] ;
         A4SecRoleId = P00383_A4SecRoleId[0] ;
         A14SecUserName = P00383_A14SecUserName[0] ;
         A12SecRoleDescription = P00383_A12SecRoleDescription[0] ;
         GXt_char4 = A172LogAccesosFullName ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char5) ;
         logaccesoswwgetfilterdata.this.GXt_char4 = GXv_char5[0] ;
         A172LogAccesosFullName = GXt_char4 ;
         if ( (GXutil.strcmp("", AV50Logaccesoswwds_1_filterfulltext)==0) || ( ( GXutil.like( GXutil.str( A41LogAccesosId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A6SecUserId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A14SecUserName , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A4SecRoleId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A12SecRoleDescription , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 120 , "%"),  ' ' ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( "ingreso" , GXutil.padr( "%" + GXutil.lower( AV50Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) ) || ( GXutil.like( "salida" , GXutil.padr( "%" + GXutil.lower( AV50Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) ) )
         {
            if ( ! ( (GXutil.strcmp("", AV62Logaccesoswwds_13_tflogaccesosfullname_sel)==0) && ( ! (GXutil.strcmp("", AV61Logaccesoswwds_12_tflogaccesosfullname)==0) ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( AV61Logaccesoswwds_12_tflogaccesosfullname , 100 , "%"),  ' ' ) ) )
            {
               if ( (GXutil.strcmp("", AV62Logaccesoswwds_13_tflogaccesosfullname_sel)==0) || ( ( GXutil.strcmp(A172LogAccesosFullName, AV62Logaccesoswwds_13_tflogaccesosfullname_sel) == 0 ) ) )
               {
                  AV39count = 0 ;
                  while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00383_A12SecRoleDescription[0], A12SecRoleDescription) == 0 ) )
                  {
                     brk384 = false ;
                     A41LogAccesosId = P00383_A41LogAccesosId[0] ;
                     A4SecRoleId = P00383_A4SecRoleId[0] ;
                     AV39count = (long)(AV39count+1) ;
                     brk384 = true ;
                     pr_default.readNext(1);
                  }
                  if ( ! (GXutil.strcmp("", A12SecRoleDescription)==0) )
                  {
                     AV31Option = A12SecRoleDescription ;
                     AV32Options.add(AV31Option, 0);
                     AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV39count), "Z,ZZZ,ZZZ,ZZ9")), 0);
                  }
                  if ( AV32Options.size() == 50 )
                  {
                     /* Exit For each command. Update data (if necessary), close cursors & exit. */
                     if (true) break;
                  }
               }
            }
         }
         if ( ! brk384 )
         {
            brk384 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADLOGACCESOSFULLNAMEOPTIONS' Routine */
      returnInSub = false ;
      AV21TFLogAccesosFullName = AV27SearchTxt ;
      AV22TFLogAccesosFullName_Sel = "" ;
      AV50Logaccesoswwds_1_filterfulltext = AV45FilterFullText ;
      AV51Logaccesoswwds_2_tflogaccesosid = AV11TFLogAccesosId ;
      AV52Logaccesoswwds_3_tflogaccesosid_to = AV12TFLogAccesosId_To ;
      AV53Logaccesoswwds_4_tfsecuserid = AV13TFSecUserId ;
      AV54Logaccesoswwds_5_tfsecuserid_to = AV14TFSecUserId_To ;
      AV55Logaccesoswwds_6_tfsecusername = AV15TFSecUserName ;
      AV56Logaccesoswwds_7_tfsecusername_sel = AV16TFSecUserName_Sel ;
      AV57Logaccesoswwds_8_tfsecroleid = AV17TFSecRoleId ;
      AV58Logaccesoswwds_9_tfsecroleid_to = AV18TFSecRoleId_To ;
      AV59Logaccesoswwds_10_tfsecroledescription = AV19TFSecRoleDescription ;
      AV60Logaccesoswwds_11_tfsecroledescription_sel = AV20TFSecRoleDescription_Sel ;
      AV61Logaccesoswwds_12_tflogaccesosfullname = AV21TFLogAccesosFullName ;
      AV62Logaccesoswwds_13_tflogaccesosfullname_sel = AV22TFLogAccesosFullName_Sel ;
      AV63Logaccesoswwds_14_tflogaccesostipo_sels = AV24TFLogAccesosTipo_Sels ;
      AV64Logaccesoswwds_15_tflogaccesosfecha = AV25TFLogAccesosFecha ;
      AV65Logaccesoswwds_16_tflogaccesosfecha_to = AV26TFLogAccesosFecha_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A227LogAccesosTipo ,
                                           AV63Logaccesoswwds_14_tflogaccesostipo_sels ,
                                           Short.valueOf(AV51Logaccesoswwds_2_tflogaccesosid) ,
                                           Short.valueOf(AV52Logaccesoswwds_3_tflogaccesosid_to) ,
                                           Short.valueOf(AV53Logaccesoswwds_4_tfsecuserid) ,
                                           Short.valueOf(AV54Logaccesoswwds_5_tfsecuserid_to) ,
                                           AV56Logaccesoswwds_7_tfsecusername_sel ,
                                           AV55Logaccesoswwds_6_tfsecusername ,
                                           Short.valueOf(AV57Logaccesoswwds_8_tfsecroleid) ,
                                           Short.valueOf(AV58Logaccesoswwds_9_tfsecroleid_to) ,
                                           AV60Logaccesoswwds_11_tfsecroledescription_sel ,
                                           AV59Logaccesoswwds_10_tfsecroledescription ,
                                           Integer.valueOf(AV63Logaccesoswwds_14_tflogaccesostipo_sels.size()) ,
                                           AV64Logaccesoswwds_15_tflogaccesosfecha ,
                                           AV65Logaccesoswwds_16_tflogaccesosfecha_to ,
                                           Short.valueOf(A41LogAccesosId) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           Short.valueOf(A4SecRoleId) ,
                                           A12SecRoleDescription ,
                                           A228LogAccesosFecha ,
                                           AV50Logaccesoswwds_1_filterfulltext ,
                                           A172LogAccesosFullName ,
                                           AV62Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                           AV61Logaccesoswwds_12_tflogaccesosfullname } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV55Logaccesoswwds_6_tfsecusername = GXutil.concat( GXutil.rtrim( AV55Logaccesoswwds_6_tfsecusername), "%", "") ;
      lV59Logaccesoswwds_10_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV59Logaccesoswwds_10_tfsecroledescription), "%", "") ;
      /* Using cursor P00384 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV51Logaccesoswwds_2_tflogaccesosid), Short.valueOf(AV52Logaccesoswwds_3_tflogaccesosid_to), Short.valueOf(AV53Logaccesoswwds_4_tfsecuserid), Short.valueOf(AV54Logaccesoswwds_5_tfsecuserid_to), lV55Logaccesoswwds_6_tfsecusername, AV56Logaccesoswwds_7_tfsecusername_sel, Short.valueOf(AV57Logaccesoswwds_8_tfsecroleid), Short.valueOf(AV58Logaccesoswwds_9_tfsecroleid_to), lV59Logaccesoswwds_10_tfsecroledescription, AV60Logaccesoswwds_11_tfsecroledescription_sel, AV64Logaccesoswwds_15_tflogaccesosfecha, AV65Logaccesoswwds_16_tflogaccesosfecha_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A228LogAccesosFecha = P00384_A228LogAccesosFecha[0] ;
         A6SecUserId = P00384_A6SecUserId[0] ;
         A41LogAccesosId = P00384_A41LogAccesosId[0] ;
         A227LogAccesosTipo = P00384_A227LogAccesosTipo[0] ;
         A12SecRoleDescription = P00384_A12SecRoleDescription[0] ;
         A14SecUserName = P00384_A14SecUserName[0] ;
         A4SecRoleId = P00384_A4SecRoleId[0] ;
         A14SecUserName = P00384_A14SecUserName[0] ;
         A12SecRoleDescription = P00384_A12SecRoleDescription[0] ;
         GXt_char4 = A172LogAccesosFullName ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char5) ;
         logaccesoswwgetfilterdata.this.GXt_char4 = GXv_char5[0] ;
         A172LogAccesosFullName = GXt_char4 ;
         if ( (GXutil.strcmp("", AV50Logaccesoswwds_1_filterfulltext)==0) || ( ( GXutil.like( GXutil.str( A41LogAccesosId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A6SecUserId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A14SecUserName , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A4SecRoleId, 4, 0) , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A12SecRoleDescription , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 120 , "%"),  ' ' ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( "%" + AV50Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( "ingreso" , GXutil.padr( "%" + GXutil.lower( AV50Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) ) || ( GXutil.like( "salida" , GXutil.padr( "%" + GXutil.lower( AV50Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) ) )
         {
            if ( ! ( (GXutil.strcmp("", AV62Logaccesoswwds_13_tflogaccesosfullname_sel)==0) && ( ! (GXutil.strcmp("", AV61Logaccesoswwds_12_tflogaccesosfullname)==0) ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( AV61Logaccesoswwds_12_tflogaccesosfullname , 100 , "%"),  ' ' ) ) )
            {
               if ( (GXutil.strcmp("", AV62Logaccesoswwds_13_tflogaccesosfullname_sel)==0) || ( ( GXutil.strcmp(A172LogAccesosFullName, AV62Logaccesoswwds_13_tflogaccesosfullname_sel) == 0 ) ) )
               {
                  if ( ! (GXutil.strcmp("", A172LogAccesosFullName)==0) )
                  {
                     AV31Option = A172LogAccesosFullName ;
                     AV30InsertIndex = 1 ;
                     while ( ( AV30InsertIndex <= AV32Options.size() ) && ( GXutil.strcmp((String)AV32Options.elementAt(-1+AV30InsertIndex), AV31Option) < 0 ) )
                     {
                        AV30InsertIndex = (int)(AV30InsertIndex+1) ;
                     }
                     if ( ( AV30InsertIndex <= AV32Options.size() ) && ( GXutil.strcmp((String)AV32Options.elementAt(-1+AV30InsertIndex), AV31Option) == 0 ) )
                     {
                        AV39count = GXutil.lval( (String)AV37OptionIndexes.elementAt(-1+AV30InsertIndex)) ;
                        AV39count = (long)(AV39count+1) ;
                        AV37OptionIndexes.removeItem(AV30InsertIndex);
                        AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV39count), "Z,ZZZ,ZZZ,ZZ9")), AV30InsertIndex);
                     }
                     else
                     {
                        AV32Options.add(AV31Option, AV30InsertIndex);
                        AV37OptionIndexes.add("1", AV30InsertIndex);
                     }
                  }
                  if ( AV32Options.size() == 50 )
                  {
                     /* Exit For each command. Update data (if necessary), close cursors & exit. */
                     if (true) break;
                  }
               }
            }
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = logaccesoswwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = logaccesoswwgetfilterdata.this.AV36OptionsDescJson;
      this.aP5[0] = logaccesoswwgetfilterdata.this.AV38OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33OptionsJson = "" ;
      AV36OptionsDescJson = "" ;
      AV38OptionIndexesJson = "" ;
      AV32Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV40Session = httpContext.getWebSession();
      AV42GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV43GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV45FilterFullText = "" ;
      AV15TFSecUserName = "" ;
      AV16TFSecUserName_Sel = "" ;
      AV19TFSecRoleDescription = "" ;
      AV20TFSecRoleDescription_Sel = "" ;
      AV21TFLogAccesosFullName = "" ;
      AV22TFLogAccesosFullName_Sel = "" ;
      AV23TFLogAccesosTipo_SelsJson = "" ;
      AV24TFLogAccesosTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFLogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      AV26TFLogAccesosFecha_To = GXutil.resetTime( GXutil.nullDate() );
      A14SecUserName = "" ;
      AV50Logaccesoswwds_1_filterfulltext = "" ;
      AV55Logaccesoswwds_6_tfsecusername = "" ;
      AV56Logaccesoswwds_7_tfsecusername_sel = "" ;
      AV59Logaccesoswwds_10_tfsecroledescription = "" ;
      AV60Logaccesoswwds_11_tfsecroledescription_sel = "" ;
      AV61Logaccesoswwds_12_tflogaccesosfullname = "" ;
      AV62Logaccesoswwds_13_tflogaccesosfullname_sel = "" ;
      AV63Logaccesoswwds_14_tflogaccesostipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Logaccesoswwds_15_tflogaccesosfecha = GXutil.resetTime( GXutil.nullDate() );
      AV65Logaccesoswwds_16_tflogaccesosfecha_to = GXutil.resetTime( GXutil.nullDate() );
      lV50Logaccesoswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV55Logaccesoswwds_6_tfsecusername = "" ;
      lV59Logaccesoswwds_10_tfsecroledescription = "" ;
      A227LogAccesosTipo = "" ;
      A12SecRoleDescription = "" ;
      A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      A172LogAccesosFullName = "" ;
      P00382_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00382_A6SecUserId = new short[1] ;
      P00382_A41LogAccesosId = new short[1] ;
      P00382_A227LogAccesosTipo = new String[] {""} ;
      P00382_A12SecRoleDescription = new String[] {""} ;
      P00382_A14SecUserName = new String[] {""} ;
      P00382_A4SecRoleId = new short[1] ;
      AV31Option = "" ;
      P00383_A12SecRoleDescription = new String[] {""} ;
      P00383_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00383_A6SecUserId = new short[1] ;
      P00383_A41LogAccesosId = new short[1] ;
      P00383_A227LogAccesosTipo = new String[] {""} ;
      P00383_A14SecUserName = new String[] {""} ;
      P00383_A4SecRoleId = new short[1] ;
      P00384_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00384_A6SecUserId = new short[1] ;
      P00384_A41LogAccesosId = new short[1] ;
      P00384_A227LogAccesosTipo = new String[] {""} ;
      P00384_A12SecRoleDescription = new String[] {""} ;
      P00384_A14SecUserName = new String[] {""} ;
      P00384_A4SecRoleId = new short[1] ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.logaccesoswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00382_A228LogAccesosFecha, P00382_A6SecUserId, P00382_A41LogAccesosId, P00382_A227LogAccesosTipo, P00382_A12SecRoleDescription, P00382_A14SecUserName, P00382_A4SecRoleId
            }
            , new Object[] {
            P00383_A12SecRoleDescription, P00383_A228LogAccesosFecha, P00383_A6SecUserId, P00383_A41LogAccesosId, P00383_A227LogAccesosTipo, P00383_A14SecUserName, P00383_A4SecRoleId
            }
            , new Object[] {
            P00384_A228LogAccesosFecha, P00384_A6SecUserId, P00384_A41LogAccesosId, P00384_A227LogAccesosTipo, P00384_A12SecRoleDescription, P00384_A14SecUserName, P00384_A4SecRoleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFLogAccesosId ;
   private short AV12TFLogAccesosId_To ;
   private short AV13TFSecUserId ;
   private short AV14TFSecUserId_To ;
   private short AV17TFSecRoleId ;
   private short AV18TFSecRoleId_To ;
   private short AV51Logaccesoswwds_2_tflogaccesosid ;
   private short AV52Logaccesoswwds_3_tflogaccesosid_to ;
   private short AV53Logaccesoswwds_4_tfsecuserid ;
   private short AV54Logaccesoswwds_5_tfsecuserid_to ;
   private short AV57Logaccesoswwds_8_tfsecroleid ;
   private short AV58Logaccesoswwds_9_tfsecroleid_to ;
   private short A41LogAccesosId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short Gx_err ;
   private int AV48GXV1 ;
   private int AV63Logaccesoswwds_14_tflogaccesostipo_sels_size ;
   private int AV30InsertIndex ;
   private long AV39count ;
   private String scmdbuf ;
   private String A227LogAccesosTipo ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date AV25TFLogAccesosFecha ;
   private java.util.Date AV26TFLogAccesosFecha_To ;
   private java.util.Date AV64Logaccesoswwds_15_tflogaccesosfecha ;
   private java.util.Date AV65Logaccesoswwds_16_tflogaccesosfecha_to ;
   private java.util.Date A228LogAccesosFecha ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk382 ;
   private boolean brk384 ;
   private String AV33OptionsJson ;
   private String AV36OptionsDescJson ;
   private String AV38OptionIndexesJson ;
   private String AV23TFLogAccesosTipo_SelsJson ;
   private String AV29DDOName ;
   private String AV27SearchTxt ;
   private String AV28SearchTxtTo ;
   private String AV45FilterFullText ;
   private String AV15TFSecUserName ;
   private String AV16TFSecUserName_Sel ;
   private String AV19TFSecRoleDescription ;
   private String AV20TFSecRoleDescription_Sel ;
   private String AV21TFLogAccesosFullName ;
   private String AV22TFLogAccesosFullName_Sel ;
   private String A14SecUserName ;
   private String AV50Logaccesoswwds_1_filterfulltext ;
   private String AV55Logaccesoswwds_6_tfsecusername ;
   private String AV56Logaccesoswwds_7_tfsecusername_sel ;
   private String AV59Logaccesoswwds_10_tfsecroledescription ;
   private String AV60Logaccesoswwds_11_tfsecroledescription_sel ;
   private String AV61Logaccesoswwds_12_tflogaccesosfullname ;
   private String AV62Logaccesoswwds_13_tflogaccesosfullname_sel ;
   private String lV50Logaccesoswwds_1_filterfulltext ;
   private String lV55Logaccesoswwds_6_tfsecusername ;
   private String lV59Logaccesoswwds_10_tfsecroledescription ;
   private String A12SecRoleDescription ;
   private String A172LogAccesosFullName ;
   private String AV31Option ;
   private com.genexus.webpanels.WebSession AV40Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00382_A228LogAccesosFecha ;
   private short[] P00382_A6SecUserId ;
   private short[] P00382_A41LogAccesosId ;
   private String[] P00382_A227LogAccesosTipo ;
   private String[] P00382_A12SecRoleDescription ;
   private String[] P00382_A14SecUserName ;
   private short[] P00382_A4SecRoleId ;
   private String[] P00383_A12SecRoleDescription ;
   private java.util.Date[] P00383_A228LogAccesosFecha ;
   private short[] P00383_A6SecUserId ;
   private short[] P00383_A41LogAccesosId ;
   private String[] P00383_A227LogAccesosTipo ;
   private String[] P00383_A14SecUserName ;
   private short[] P00383_A4SecRoleId ;
   private java.util.Date[] P00384_A228LogAccesosFecha ;
   private short[] P00384_A6SecUserId ;
   private short[] P00384_A41LogAccesosId ;
   private String[] P00384_A227LogAccesosTipo ;
   private String[] P00384_A12SecRoleDescription ;
   private String[] P00384_A14SecUserName ;
   private short[] P00384_A4SecRoleId ;
   private GXSimpleCollection<String> AV24TFLogAccesosTipo_Sels ;
   private GXSimpleCollection<String> AV63Logaccesoswwds_14_tflogaccesostipo_sels ;
   private GXSimpleCollection<String> AV32Options ;
   private GXSimpleCollection<String> AV35OptionsDesc ;
   private GXSimpleCollection<String> AV37OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV42GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV43GridStateFilterValue ;
}

final  class logaccesoswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00382( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A227LogAccesosTipo ,
                                          GXSimpleCollection<String> AV63Logaccesoswwds_14_tflogaccesostipo_sels ,
                                          short AV51Logaccesoswwds_2_tflogaccesosid ,
                                          short AV52Logaccesoswwds_3_tflogaccesosid_to ,
                                          short AV53Logaccesoswwds_4_tfsecuserid ,
                                          short AV54Logaccesoswwds_5_tfsecuserid_to ,
                                          String AV56Logaccesoswwds_7_tfsecusername_sel ,
                                          String AV55Logaccesoswwds_6_tfsecusername ,
                                          short AV57Logaccesoswwds_8_tfsecroleid ,
                                          short AV58Logaccesoswwds_9_tfsecroleid_to ,
                                          String AV60Logaccesoswwds_11_tfsecroledescription_sel ,
                                          String AV59Logaccesoswwds_10_tfsecroledescription ,
                                          int AV63Logaccesoswwds_14_tflogaccesostipo_sels_size ,
                                          java.util.Date AV64Logaccesoswwds_15_tflogaccesosfecha ,
                                          java.util.Date AV65Logaccesoswwds_16_tflogaccesosfecha_to ,
                                          short A41LogAccesosId ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          short A4SecRoleId ,
                                          String A12SecRoleDescription ,
                                          java.util.Date A228LogAccesosFecha ,
                                          String AV50Logaccesoswwds_1_filterfulltext ,
                                          String A172LogAccesosFullName ,
                                          String AV62Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                          String AV61Logaccesoswwds_12_tflogaccesosfullname )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[12];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T1.[LogAccesosFecha], T1.[SecUserId], T1.[LogAccesosId], T1.[LogAccesosTipo], T3.[SecRoleDescription], T2.[SecUserName], T1.[SecRoleId] FROM (([LogAccesos]" ;
      scmdbuf += " T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = T1.[SecRoleId])" ;
      if ( ! (0==AV51Logaccesoswwds_2_tflogaccesosid) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] >= ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      if ( ! (0==AV52Logaccesoswwds_3_tflogaccesosid_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] <= ?)");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      if ( ! (0==AV53Logaccesoswwds_4_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      if ( ! (0==AV54Logaccesoswwds_5_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int6[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Logaccesoswwds_7_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV55Logaccesoswwds_6_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] like ?)");
      }
      else
      {
         GXv_int6[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Logaccesoswwds_7_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] = ?)");
      }
      else
      {
         GXv_int6[5] = (byte)(1) ;
      }
      if ( ! (0==AV57Logaccesoswwds_8_tfsecroleid) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] >= ?)");
      }
      else
      {
         GXv_int6[6] = (byte)(1) ;
      }
      if ( ! (0==AV58Logaccesoswwds_9_tfsecroleid_to) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] <= ?)");
      }
      else
      {
         GXv_int6[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Logaccesoswwds_11_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV59Logaccesoswwds_10_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int6[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Logaccesoswwds_11_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int6[9] = (byte)(1) ;
      }
      if ( AV63Logaccesoswwds_14_tflogaccesostipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV63Logaccesoswwds_14_tflogaccesostipo_sels, "T1.[LogAccesosTipo] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV64Logaccesoswwds_15_tflogaccesosfecha) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] >= ?)");
      }
      else
      {
         GXv_int6[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV65Logaccesoswwds_16_tflogaccesosfecha_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] <= ?)");
      }
      else
      {
         GXv_int6[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[SecUserName]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P00383( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A227LogAccesosTipo ,
                                          GXSimpleCollection<String> AV63Logaccesoswwds_14_tflogaccesostipo_sels ,
                                          short AV51Logaccesoswwds_2_tflogaccesosid ,
                                          short AV52Logaccesoswwds_3_tflogaccesosid_to ,
                                          short AV53Logaccesoswwds_4_tfsecuserid ,
                                          short AV54Logaccesoswwds_5_tfsecuserid_to ,
                                          String AV56Logaccesoswwds_7_tfsecusername_sel ,
                                          String AV55Logaccesoswwds_6_tfsecusername ,
                                          short AV57Logaccesoswwds_8_tfsecroleid ,
                                          short AV58Logaccesoswwds_9_tfsecroleid_to ,
                                          String AV60Logaccesoswwds_11_tfsecroledescription_sel ,
                                          String AV59Logaccesoswwds_10_tfsecroledescription ,
                                          int AV63Logaccesoswwds_14_tflogaccesostipo_sels_size ,
                                          java.util.Date AV64Logaccesoswwds_15_tflogaccesosfecha ,
                                          java.util.Date AV65Logaccesoswwds_16_tflogaccesosfecha_to ,
                                          short A41LogAccesosId ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          short A4SecRoleId ,
                                          String A12SecRoleDescription ,
                                          java.util.Date A228LogAccesosFecha ,
                                          String AV50Logaccesoswwds_1_filterfulltext ,
                                          String A172LogAccesosFullName ,
                                          String AV62Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                          String AV61Logaccesoswwds_12_tflogaccesosfullname )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[12];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT T3.[SecRoleDescription], T1.[LogAccesosFecha], T1.[SecUserId], T1.[LogAccesosId], T1.[LogAccesosTipo], T2.[SecUserName], T1.[SecRoleId] FROM (([LogAccesos]" ;
      scmdbuf += " T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = T1.[SecRoleId])" ;
      if ( ! (0==AV51Logaccesoswwds_2_tflogaccesosid) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] >= ?)");
      }
      else
      {
         GXv_int9[0] = (byte)(1) ;
      }
      if ( ! (0==AV52Logaccesoswwds_3_tflogaccesosid_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] <= ?)");
      }
      else
      {
         GXv_int9[1] = (byte)(1) ;
      }
      if ( ! (0==AV53Logaccesoswwds_4_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int9[2] = (byte)(1) ;
      }
      if ( ! (0==AV54Logaccesoswwds_5_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int9[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Logaccesoswwds_7_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV55Logaccesoswwds_6_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] like ?)");
      }
      else
      {
         GXv_int9[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Logaccesoswwds_7_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] = ?)");
      }
      else
      {
         GXv_int9[5] = (byte)(1) ;
      }
      if ( ! (0==AV57Logaccesoswwds_8_tfsecroleid) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] >= ?)");
      }
      else
      {
         GXv_int9[6] = (byte)(1) ;
      }
      if ( ! (0==AV58Logaccesoswwds_9_tfsecroleid_to) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] <= ?)");
      }
      else
      {
         GXv_int9[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Logaccesoswwds_11_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV59Logaccesoswwds_10_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int9[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Logaccesoswwds_11_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int9[9] = (byte)(1) ;
      }
      if ( AV63Logaccesoswwds_14_tflogaccesostipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV63Logaccesoswwds_14_tflogaccesostipo_sels, "T1.[LogAccesosTipo] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV64Logaccesoswwds_15_tflogaccesosfecha) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] >= ?)");
      }
      else
      {
         GXv_int9[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV65Logaccesoswwds_16_tflogaccesosfecha_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] <= ?)");
      }
      else
      {
         GXv_int9[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[SecRoleDescription]" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
   }

   protected Object[] conditional_P00384( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A227LogAccesosTipo ,
                                          GXSimpleCollection<String> AV63Logaccesoswwds_14_tflogaccesostipo_sels ,
                                          short AV51Logaccesoswwds_2_tflogaccesosid ,
                                          short AV52Logaccesoswwds_3_tflogaccesosid_to ,
                                          short AV53Logaccesoswwds_4_tfsecuserid ,
                                          short AV54Logaccesoswwds_5_tfsecuserid_to ,
                                          String AV56Logaccesoswwds_7_tfsecusername_sel ,
                                          String AV55Logaccesoswwds_6_tfsecusername ,
                                          short AV57Logaccesoswwds_8_tfsecroleid ,
                                          short AV58Logaccesoswwds_9_tfsecroleid_to ,
                                          String AV60Logaccesoswwds_11_tfsecroledescription_sel ,
                                          String AV59Logaccesoswwds_10_tfsecroledescription ,
                                          int AV63Logaccesoswwds_14_tflogaccesostipo_sels_size ,
                                          java.util.Date AV64Logaccesoswwds_15_tflogaccesosfecha ,
                                          java.util.Date AV65Logaccesoswwds_16_tflogaccesosfecha_to ,
                                          short A41LogAccesosId ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          short A4SecRoleId ,
                                          String A12SecRoleDescription ,
                                          java.util.Date A228LogAccesosFecha ,
                                          String AV50Logaccesoswwds_1_filterfulltext ,
                                          String A172LogAccesosFullName ,
                                          String AV62Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                          String AV61Logaccesoswwds_12_tflogaccesosfullname )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[12];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT T1.[LogAccesosFecha], T1.[SecUserId], T1.[LogAccesosId], T1.[LogAccesosTipo], T3.[SecRoleDescription], T2.[SecUserName], T1.[SecRoleId] FROM (([LogAccesos]" ;
      scmdbuf += " T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = T1.[SecRoleId])" ;
      if ( ! (0==AV51Logaccesoswwds_2_tflogaccesosid) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] >= ?)");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      if ( ! (0==AV52Logaccesoswwds_3_tflogaccesosid_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] <= ?)");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( ! (0==AV53Logaccesoswwds_4_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( ! (0==AV54Logaccesoswwds_5_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Logaccesoswwds_7_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV55Logaccesoswwds_6_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] like ?)");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Logaccesoswwds_7_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] = ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( ! (0==AV57Logaccesoswwds_8_tfsecroleid) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] >= ?)");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( ! (0==AV58Logaccesoswwds_9_tfsecroleid_to) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] <= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Logaccesoswwds_11_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV59Logaccesoswwds_10_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Logaccesoswwds_11_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      if ( AV63Logaccesoswwds_14_tflogaccesostipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV63Logaccesoswwds_14_tflogaccesostipo_sels, "T1.[LogAccesosTipo] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV64Logaccesoswwds_15_tflogaccesosfecha) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] >= ?)");
      }
      else
      {
         GXv_int12[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV65Logaccesoswwds_16_tflogaccesosfecha_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] <= ?)");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[LogAccesosId]" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_P00382(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] );
            case 1 :
                  return conditional_P00383(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] );
            case 2 :
                  return conditional_P00384(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00382", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00383", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00384", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 120);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 120);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[22], false);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[23], false);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 120);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 120);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[22], false);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[23], false);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 120);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 120);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[22], false);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[23], false);
               }
               return;
      }
   }

}

