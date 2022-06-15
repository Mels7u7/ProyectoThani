package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalitywwgetfilterdata extends GXProcedure
{
   public secfunctionalitywwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalitywwgetfilterdata.class ), "" );
   }

   public secfunctionalitywwgetfilterdata( int remoteHandle ,
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
      secfunctionalitywwgetfilterdata.this.aP5 = new String[] {""};
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
      secfunctionalitywwgetfilterdata.this.AV19DDOName = aP0;
      secfunctionalitywwgetfilterdata.this.AV17SearchTxt = aP1;
      secfunctionalitywwgetfilterdata.this.AV18SearchTxtTo = aP2;
      secfunctionalitywwgetfilterdata.this.aP3 = aP3;
      secfunctionalitywwgetfilterdata.this.aP4 = aP4;
      secfunctionalitywwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
      secfunctionalitywwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV38WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV38WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECFUNCTIONALITYKEY") == 0 )
         {
            /* Execute user subroutine: 'LOADSECFUNCTIONALITYKEYOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECFUNCTIONALITYDESCRIPTIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECPARENTFUNCTIONALITYDESCRIPTIONOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV23OptionsJson = AV22Options.toJSonString(false) ;
      AV26OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV28OptionIndexesJson = AV27OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalityWWGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWGridState"), null, null);
      }
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV41FilterFullText = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV10TFSecFunctionalityKey = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV11TFSecFunctionalityKey_Sel = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV12TFSecFunctionalityDescription = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV13TFSecFunctionalityDescription_Sel = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV39TFSecFunctionalityType_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFSecFunctionalityType_Sels.fromJSonString(AV39TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV15TFSecParentFunctionalityDescription = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV16TFSecParentFunctionalityDescription_Sel = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECFUNCTIONALITYKEYOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSecFunctionalityKey = AV17SearchTxt ;
      AV11TFSecFunctionalityKey_Sel = "" ;
      AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV41FilterFullText ;
      AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV10TFSecFunctionalityKey ;
      AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV11TFSecFunctionalityKey_Sel ;
      AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV12TFSecFunctionalityDescription ;
      AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV13TFSecFunctionalityDescription_Sel ;
      AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV40TFSecFunctionalityType_Sels ;
      AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV15TFSecParentFunctionalityDescription ;
      AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV16TFSecParentFunctionalityDescription_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                           AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                           AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                           AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                           AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                           AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                           AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey), "%", "") ;
      lV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P00202 */
      pr_default.execute(0, new Object[] {lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey, AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel, lV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription, AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel, lV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription, AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk202 = false ;
         A2SecParentFunctionalityId = P00202_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P00202_n2SecParentFunctionalityId[0] ;
         A3SecFunctionalityKey = P00202_A3SecFunctionalityKey[0] ;
         A11SecParentFunctionalityDescription = P00202_A11SecParentFunctionalityDescription[0] ;
         A9SecFunctionalityType = P00202_A9SecFunctionalityType[0] ;
         A8SecFunctionalityDescription = P00202_A8SecFunctionalityDescription[0] ;
         A1SecFunctionalityId = P00202_A1SecFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P00202_A11SecParentFunctionalityDescription[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00202_A3SecFunctionalityKey[0], A3SecFunctionalityKey) == 0 ) )
         {
            brk202 = false ;
            A1SecFunctionalityId = P00202_A1SecFunctionalityId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk202 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A3SecFunctionalityKey)==0) )
         {
            AV21Option = A3SecFunctionalityKey ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk202 )
         {
            brk202 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECFUNCTIONALITYDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSecFunctionalityDescription = AV17SearchTxt ;
      AV13TFSecFunctionalityDescription_Sel = "" ;
      AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV41FilterFullText ;
      AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV10TFSecFunctionalityKey ;
      AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV11TFSecFunctionalityKey_Sel ;
      AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV12TFSecFunctionalityDescription ;
      AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV13TFSecFunctionalityDescription_Sel ;
      AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV40TFSecFunctionalityType_Sels ;
      AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV15TFSecParentFunctionalityDescription ;
      AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV16TFSecParentFunctionalityDescription_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                           AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                           AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                           AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                           AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                           AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                           AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey), "%", "") ;
      lV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P00203 */
      pr_default.execute(1, new Object[] {lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey, AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel, lV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription, AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel, lV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription, AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk204 = false ;
         A2SecParentFunctionalityId = P00203_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P00203_n2SecParentFunctionalityId[0] ;
         A8SecFunctionalityDescription = P00203_A8SecFunctionalityDescription[0] ;
         A11SecParentFunctionalityDescription = P00203_A11SecParentFunctionalityDescription[0] ;
         A9SecFunctionalityType = P00203_A9SecFunctionalityType[0] ;
         A3SecFunctionalityKey = P00203_A3SecFunctionalityKey[0] ;
         A1SecFunctionalityId = P00203_A1SecFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P00203_A11SecParentFunctionalityDescription[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00203_A8SecFunctionalityDescription[0], A8SecFunctionalityDescription) == 0 ) )
         {
            brk204 = false ;
            A1SecFunctionalityId = P00203_A1SecFunctionalityId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk204 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A8SecFunctionalityDescription)==0) )
         {
            AV21Option = A8SecFunctionalityDescription ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk204 )
         {
            brk204 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADSECPARENTFUNCTIONALITYDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFSecParentFunctionalityDescription = AV17SearchTxt ;
      AV16TFSecParentFunctionalityDescription_Sel = "" ;
      AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV41FilterFullText ;
      AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV10TFSecFunctionalityKey ;
      AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV11TFSecFunctionalityKey_Sel ;
      AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV12TFSecFunctionalityDescription ;
      AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV13TFSecFunctionalityDescription_Sel ;
      AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV40TFSecFunctionalityType_Sels ;
      AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV15TFSecParentFunctionalityDescription ;
      AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV16TFSecParentFunctionalityDescription_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                           AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                           AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                           AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                           AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                           AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                           AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey), "%", "") ;
      lV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P00204 */
      pr_default.execute(2, new Object[] {lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey, AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel, lV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription, AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel, lV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription, AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk206 = false ;
         A2SecParentFunctionalityId = P00204_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P00204_n2SecParentFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P00204_A11SecParentFunctionalityDescription[0] ;
         A9SecFunctionalityType = P00204_A9SecFunctionalityType[0] ;
         A8SecFunctionalityDescription = P00204_A8SecFunctionalityDescription[0] ;
         A3SecFunctionalityKey = P00204_A3SecFunctionalityKey[0] ;
         A1SecFunctionalityId = P00204_A1SecFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P00204_A11SecParentFunctionalityDescription[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00204_A11SecParentFunctionalityDescription[0], A11SecParentFunctionalityDescription) == 0 ) )
         {
            brk206 = false ;
            A2SecParentFunctionalityId = P00204_A2SecParentFunctionalityId[0] ;
            n2SecParentFunctionalityId = P00204_n2SecParentFunctionalityId[0] ;
            A1SecFunctionalityId = P00204_A1SecFunctionalityId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk206 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A11SecParentFunctionalityDescription)==0) )
         {
            AV21Option = A11SecParentFunctionalityDescription ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk206 )
         {
            brk206 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secfunctionalitywwgetfilterdata.this.AV23OptionsJson;
      this.aP4[0] = secfunctionalitywwgetfilterdata.this.AV26OptionsDescJson;
      this.aP5[0] = secfunctionalitywwgetfilterdata.this.AV28OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23OptionsJson = "" ;
      AV26OptionsDescJson = "" ;
      AV28OptionIndexesJson = "" ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV38WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41FilterFullText = "" ;
      AV10TFSecFunctionalityKey = "" ;
      AV11TFSecFunctionalityKey_Sel = "" ;
      AV12TFSecFunctionalityDescription = "" ;
      AV13TFSecFunctionalityDescription_Sel = "" ;
      AV39TFSecFunctionalityType_SelsJson = "" ;
      AV40TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV15TFSecParentFunctionalityDescription = "" ;
      AV16TFSecParentFunctionalityDescription_Sel = "" ;
      A3SecFunctionalityKey = "" ;
      AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = "" ;
      AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = "" ;
      AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = "" ;
      AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = "" ;
      AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = "" ;
      AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = "" ;
      AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = "" ;
      scmdbuf = "" ;
      lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = "" ;
      lV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = "" ;
      lV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = "" ;
      lV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      P00202_A2SecParentFunctionalityId = new long[1] ;
      P00202_n2SecParentFunctionalityId = new boolean[] {false} ;
      P00202_A3SecFunctionalityKey = new String[] {""} ;
      P00202_A11SecParentFunctionalityDescription = new String[] {""} ;
      P00202_A9SecFunctionalityType = new byte[1] ;
      P00202_A8SecFunctionalityDescription = new String[] {""} ;
      P00202_A1SecFunctionalityId = new long[1] ;
      AV21Option = "" ;
      P00203_A2SecParentFunctionalityId = new long[1] ;
      P00203_n2SecParentFunctionalityId = new boolean[] {false} ;
      P00203_A8SecFunctionalityDescription = new String[] {""} ;
      P00203_A11SecParentFunctionalityDescription = new String[] {""} ;
      P00203_A9SecFunctionalityType = new byte[1] ;
      P00203_A3SecFunctionalityKey = new String[] {""} ;
      P00203_A1SecFunctionalityId = new long[1] ;
      P00204_A2SecParentFunctionalityId = new long[1] ;
      P00204_n2SecParentFunctionalityId = new boolean[] {false} ;
      P00204_A11SecParentFunctionalityDescription = new String[] {""} ;
      P00204_A9SecFunctionalityType = new byte[1] ;
      P00204_A8SecFunctionalityDescription = new String[] {""} ;
      P00204_A3SecFunctionalityKey = new String[] {""} ;
      P00204_A1SecFunctionalityId = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secfunctionalitywwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00202_A2SecParentFunctionalityId, P00202_n2SecParentFunctionalityId, P00202_A3SecFunctionalityKey, P00202_A11SecParentFunctionalityDescription, P00202_A9SecFunctionalityType, P00202_A8SecFunctionalityDescription, P00202_A1SecFunctionalityId
            }
            , new Object[] {
            P00203_A2SecParentFunctionalityId, P00203_n2SecParentFunctionalityId, P00203_A8SecFunctionalityDescription, P00203_A11SecParentFunctionalityDescription, P00203_A9SecFunctionalityType, P00203_A3SecFunctionalityKey, P00203_A1SecFunctionalityId
            }
            , new Object[] {
            P00204_A2SecParentFunctionalityId, P00204_n2SecParentFunctionalityId, P00204_A11SecParentFunctionalityDescription, P00204_A9SecFunctionalityType, P00204_A8SecFunctionalityDescription, P00204_A3SecFunctionalityKey, P00204_A1SecFunctionalityId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A9SecFunctionalityType ;
   private short Gx_err ;
   private int AV44GXV1 ;
   private int AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ;
   private long A2SecParentFunctionalityId ;
   private long A1SecFunctionalityId ;
   private long AV29count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk202 ;
   private boolean n2SecParentFunctionalityId ;
   private boolean brk204 ;
   private boolean brk206 ;
   private String AV23OptionsJson ;
   private String AV26OptionsDescJson ;
   private String AV28OptionIndexesJson ;
   private String AV39TFSecFunctionalityType_SelsJson ;
   private String AV19DDOName ;
   private String AV17SearchTxt ;
   private String AV18SearchTxtTo ;
   private String AV41FilterFullText ;
   private String AV10TFSecFunctionalityKey ;
   private String AV11TFSecFunctionalityKey_Sel ;
   private String AV12TFSecFunctionalityDescription ;
   private String AV13TFSecFunctionalityDescription_Sel ;
   private String AV15TFSecParentFunctionalityDescription ;
   private String AV16TFSecParentFunctionalityDescription_Sel ;
   private String A3SecFunctionalityKey ;
   private String AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ;
   private String AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ;
   private String AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ;
   private String AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ;
   private String AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ;
   private String AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ;
   private String AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ;
   private String lV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ;
   private String lV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ;
   private String lV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ;
   private String lV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String AV21Option ;
   private GXSimpleCollection<Byte> AV40TFSecFunctionalityType_Sels ;
   private GXSimpleCollection<Byte> AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private long[] P00202_A2SecParentFunctionalityId ;
   private boolean[] P00202_n2SecParentFunctionalityId ;
   private String[] P00202_A3SecFunctionalityKey ;
   private String[] P00202_A11SecParentFunctionalityDescription ;
   private byte[] P00202_A9SecFunctionalityType ;
   private String[] P00202_A8SecFunctionalityDescription ;
   private long[] P00202_A1SecFunctionalityId ;
   private long[] P00203_A2SecParentFunctionalityId ;
   private boolean[] P00203_n2SecParentFunctionalityId ;
   private String[] P00203_A8SecFunctionalityDescription ;
   private String[] P00203_A11SecParentFunctionalityDescription ;
   private byte[] P00203_A9SecFunctionalityType ;
   private String[] P00203_A3SecFunctionalityKey ;
   private long[] P00203_A1SecFunctionalityId ;
   private long[] P00204_A2SecParentFunctionalityId ;
   private boolean[] P00204_n2SecParentFunctionalityId ;
   private String[] P00204_A11SecParentFunctionalityDescription ;
   private byte[] P00204_A9SecFunctionalityType ;
   private String[] P00204_A8SecFunctionalityDescription ;
   private String[] P00204_A3SecFunctionalityKey ;
   private long[] P00204_A1SecFunctionalityId ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV38WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secfunctionalitywwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00202( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                          String AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                          String AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                          String AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                          String AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                          String AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                          int AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ,
                                          String AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                          String AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[SecParentFunctionalityId] AS SecParentFunctionalityId, T1.[SecFunctionalityKey], T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription," ;
      scmdbuf += " T1.[SecFunctionalityType], T1.[SecFunctionalityDescription], T1.[SecFunctionalityId] FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId]" ;
      scmdbuf += " = T1.[SecParentFunctionalityId])" ;
      if ( ! (GXutil.strcmp("", AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SecFunctionalityKey]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00203( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                          String AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                          String AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                          String AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                          String AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                          String AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                          int AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ,
                                          String AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                          String AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[14];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.[SecParentFunctionalityId] AS SecParentFunctionalityId, T1.[SecFunctionalityDescription], T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription," ;
      scmdbuf += " T1.[SecFunctionalityType], T1.[SecFunctionalityKey], T1.[SecFunctionalityId] FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId]" ;
      scmdbuf += " = T1.[SecParentFunctionalityId])" ;
      if ( ! (GXutil.strcmp("", AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
         GXv_int7[5] = (byte)(1) ;
         GXv_int7[6] = (byte)(1) ;
         GXv_int7[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SecFunctionalityDescription]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P00204( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                          String AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                          String AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                          String AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                          String AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                          String AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                          int AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ,
                                          String AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                          String AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[SecParentFunctionalityId] AS SecParentFunctionalityId, T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, T1.[SecFunctionalityType]," ;
      scmdbuf += " T1.[SecFunctionalityDescription], T1.[SecFunctionalityKey], T1.[SecFunctionalityId] FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId]" ;
      scmdbuf += " = T1.[SecParentFunctionalityId])" ;
      if ( ! (GXutil.strcmp("", AV46Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
         GXv_int10[6] = (byte)(1) ;
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV47Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV49Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV51Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV52Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV53Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[SecFunctionalityDescription]" ;
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
                  return conditional_P00202(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] );
            case 1 :
                  return conditional_P00203(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] );
            case 2 :
                  return conditional_P00204(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00202", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00203", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00204", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
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
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
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
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
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
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
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

