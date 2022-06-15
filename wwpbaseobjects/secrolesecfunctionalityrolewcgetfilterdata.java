package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secrolesecfunctionalityrolewcgetfilterdata extends GXProcedure
{
   public secrolesecfunctionalityrolewcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolesecfunctionalityrolewcgetfilterdata.class ), "" );
   }

   public secrolesecfunctionalityrolewcgetfilterdata( int remoteHandle ,
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
      secrolesecfunctionalityrolewcgetfilterdata.this.aP5 = new String[] {""};
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
      secrolesecfunctionalityrolewcgetfilterdata.this.AV19DDOName = aP0;
      secrolesecfunctionalityrolewcgetfilterdata.this.AV17SearchTxt = aP1;
      secrolesecfunctionalityrolewcgetfilterdata.this.AV18SearchTxtTo = aP2;
      secrolesecfunctionalityrolewcgetfilterdata.this.aP3 = aP3;
      secrolesecfunctionalityrolewcgetfilterdata.this.aP4 = aP4;
      secrolesecfunctionalityrolewcgetfilterdata.this.aP5 = aP5;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecRole", GXv_boolean2) ;
      secrolesecfunctionalityrolewcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV51WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV51WWPContext = GXv_SdtWWPContext3[0] ;
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
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECPARENTFUNCTIONALITYDESCRIPTIONOPTIONS' */
            S131 ();
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
      if ( GXutil.strcmp(AV30Session.getValue("WWPBaseObjects.SecRoleSecFunctionalityRoleWCGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecRoleSecFunctionalityRoleWCGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("WWPBaseObjects.SecRoleSecFunctionalityRoleWCGridState"), null, null);
      }
      AV57GXV1 = 1 ;
      while ( AV57GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV57GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV54FilterFullText = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SECFUNCTIONALITYTYPE") == 0 )
         {
            AV35SecFunctionalityType = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV10TFSecFunctionalityKey = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV11TFSecFunctionalityKey_Sel = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV52TFSecFunctionalityType_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFSecFunctionalityType_Sels.fromJSonString(AV52TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV15TFSecParentFunctionalityDescription = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV16TFSecParentFunctionalityDescription_Sel = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&SECROLEID") == 0 )
         {
            AV50SecRoleId = (short)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV57GXV1 = (int)(AV57GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECFUNCTIONALITYKEYOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSecFunctionalityKey = AV17SearchTxt ;
      AV11TFSecFunctionalityKey_Sel = "" ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV53TFSecFunctionalityType_Sels ,
                                           AV54FilterFullText ,
                                           Byte.valueOf(AV35SecFunctionalityType) ,
                                           AV11TFSecFunctionalityKey_Sel ,
                                           AV10TFSecFunctionalityKey ,
                                           Integer.valueOf(AV53TFSecFunctionalityType_Sels.size()) ,
                                           AV16TFSecParentFunctionalityDescription_Sel ,
                                           AV15TFSecParentFunctionalityDescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription ,
                                           Short.valueOf(AV50SecRoleId) ,
                                           Short.valueOf(A4SecRoleId) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV10TFSecFunctionalityKey = GXutil.concat( GXutil.rtrim( AV10TFSecFunctionalityKey), "%", "") ;
      lV15TFSecParentFunctionalityDescription = GXutil.concat( GXutil.rtrim( AV15TFSecParentFunctionalityDescription), "%", "") ;
      /* Using cursor P00242 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV50SecRoleId), lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, Byte.valueOf(AV35SecFunctionalityType), lV10TFSecFunctionalityKey, AV11TFSecFunctionalityKey_Sel, lV15TFSecParentFunctionalityDescription, AV16TFSecParentFunctionalityDescription_Sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk242 = false ;
         A1SecFunctionalityId = P00242_A1SecFunctionalityId[0] ;
         A2SecParentFunctionalityId = P00242_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P00242_n2SecParentFunctionalityId[0] ;
         A4SecRoleId = P00242_A4SecRoleId[0] ;
         A3SecFunctionalityKey = P00242_A3SecFunctionalityKey[0] ;
         A11SecParentFunctionalityDescription = P00242_A11SecParentFunctionalityDescription[0] ;
         A8SecFunctionalityDescription = P00242_A8SecFunctionalityDescription[0] ;
         A9SecFunctionalityType = P00242_A9SecFunctionalityType[0] ;
         A2SecParentFunctionalityId = P00242_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P00242_n2SecParentFunctionalityId[0] ;
         A3SecFunctionalityKey = P00242_A3SecFunctionalityKey[0] ;
         A8SecFunctionalityDescription = P00242_A8SecFunctionalityDescription[0] ;
         A9SecFunctionalityType = P00242_A9SecFunctionalityType[0] ;
         A11SecParentFunctionalityDescription = P00242_A11SecParentFunctionalityDescription[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P00242_A4SecRoleId[0] == A4SecRoleId ) && ( GXutil.strcmp(P00242_A3SecFunctionalityKey[0], A3SecFunctionalityKey) == 0 ) )
         {
            brk242 = false ;
            A1SecFunctionalityId = P00242_A1SecFunctionalityId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk242 = true ;
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
         if ( ! brk242 )
         {
            brk242 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECPARENTFUNCTIONALITYDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFSecParentFunctionalityDescription = AV17SearchTxt ;
      AV16TFSecParentFunctionalityDescription_Sel = "" ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV53TFSecFunctionalityType_Sels ,
                                           AV54FilterFullText ,
                                           Byte.valueOf(AV35SecFunctionalityType) ,
                                           AV11TFSecFunctionalityKey_Sel ,
                                           AV10TFSecFunctionalityKey ,
                                           Integer.valueOf(AV53TFSecFunctionalityType_Sels.size()) ,
                                           AV16TFSecParentFunctionalityDescription_Sel ,
                                           AV15TFSecParentFunctionalityDescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription ,
                                           Short.valueOf(AV50SecRoleId) ,
                                           Short.valueOf(A4SecRoleId) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV54FilterFullText = GXutil.concat( GXutil.rtrim( AV54FilterFullText), "%", "") ;
      lV10TFSecFunctionalityKey = GXutil.concat( GXutil.rtrim( AV10TFSecFunctionalityKey), "%", "") ;
      lV15TFSecParentFunctionalityDescription = GXutil.concat( GXutil.rtrim( AV15TFSecParentFunctionalityDescription), "%", "") ;
      /* Using cursor P00243 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV50SecRoleId), lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, lV54FilterFullText, Byte.valueOf(AV35SecFunctionalityType), lV10TFSecFunctionalityKey, AV11TFSecFunctionalityKey_Sel, lV15TFSecParentFunctionalityDescription, AV16TFSecParentFunctionalityDescription_Sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk244 = false ;
         A1SecFunctionalityId = P00243_A1SecFunctionalityId[0] ;
         A2SecParentFunctionalityId = P00243_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P00243_n2SecParentFunctionalityId[0] ;
         A4SecRoleId = P00243_A4SecRoleId[0] ;
         A11SecParentFunctionalityDescription = P00243_A11SecParentFunctionalityDescription[0] ;
         A8SecFunctionalityDescription = P00243_A8SecFunctionalityDescription[0] ;
         A9SecFunctionalityType = P00243_A9SecFunctionalityType[0] ;
         A3SecFunctionalityKey = P00243_A3SecFunctionalityKey[0] ;
         A2SecParentFunctionalityId = P00243_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P00243_n2SecParentFunctionalityId[0] ;
         A8SecFunctionalityDescription = P00243_A8SecFunctionalityDescription[0] ;
         A9SecFunctionalityType = P00243_A9SecFunctionalityType[0] ;
         A3SecFunctionalityKey = P00243_A3SecFunctionalityKey[0] ;
         A11SecParentFunctionalityDescription = P00243_A11SecParentFunctionalityDescription[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P00243_A4SecRoleId[0] == A4SecRoleId ) && ( GXutil.strcmp(P00243_A11SecParentFunctionalityDescription[0], A11SecParentFunctionalityDescription) == 0 ) )
         {
            brk244 = false ;
            A1SecFunctionalityId = P00243_A1SecFunctionalityId[0] ;
            A2SecParentFunctionalityId = P00243_A2SecParentFunctionalityId[0] ;
            n2SecParentFunctionalityId = P00243_n2SecParentFunctionalityId[0] ;
            A2SecParentFunctionalityId = P00243_A2SecParentFunctionalityId[0] ;
            n2SecParentFunctionalityId = P00243_n2SecParentFunctionalityId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk244 = true ;
            pr_default.readNext(1);
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
         if ( ! brk244 )
         {
            brk244 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secrolesecfunctionalityrolewcgetfilterdata.this.AV23OptionsJson;
      this.aP4[0] = secrolesecfunctionalityrolewcgetfilterdata.this.AV26OptionsDescJson;
      this.aP5[0] = secrolesecfunctionalityrolewcgetfilterdata.this.AV28OptionIndexesJson;
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
      AV51WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV54FilterFullText = "" ;
      AV10TFSecFunctionalityKey = "" ;
      AV11TFSecFunctionalityKey_Sel = "" ;
      AV52TFSecFunctionalityType_SelsJson = "" ;
      AV53TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV15TFSecParentFunctionalityDescription = "" ;
      AV16TFSecParentFunctionalityDescription_Sel = "" ;
      scmdbuf = "" ;
      lV54FilterFullText = "" ;
      lV10TFSecFunctionalityKey = "" ;
      lV15TFSecParentFunctionalityDescription = "" ;
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      P00242_A1SecFunctionalityId = new long[1] ;
      P00242_A2SecParentFunctionalityId = new long[1] ;
      P00242_n2SecParentFunctionalityId = new boolean[] {false} ;
      P00242_A4SecRoleId = new short[1] ;
      P00242_A3SecFunctionalityKey = new String[] {""} ;
      P00242_A11SecParentFunctionalityDescription = new String[] {""} ;
      P00242_A8SecFunctionalityDescription = new String[] {""} ;
      P00242_A9SecFunctionalityType = new byte[1] ;
      AV21Option = "" ;
      P00243_A1SecFunctionalityId = new long[1] ;
      P00243_A2SecParentFunctionalityId = new long[1] ;
      P00243_n2SecParentFunctionalityId = new boolean[] {false} ;
      P00243_A4SecRoleId = new short[1] ;
      P00243_A11SecParentFunctionalityDescription = new String[] {""} ;
      P00243_A8SecFunctionalityDescription = new String[] {""} ;
      P00243_A9SecFunctionalityType = new byte[1] ;
      P00243_A3SecFunctionalityKey = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secrolesecfunctionalityrolewcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00242_A1SecFunctionalityId, P00242_A2SecParentFunctionalityId, P00242_n2SecParentFunctionalityId, P00242_A4SecRoleId, P00242_A3SecFunctionalityKey, P00242_A11SecParentFunctionalityDescription, P00242_A8SecFunctionalityDescription, P00242_A9SecFunctionalityType
            }
            , new Object[] {
            P00243_A1SecFunctionalityId, P00243_A2SecParentFunctionalityId, P00243_n2SecParentFunctionalityId, P00243_A4SecRoleId, P00243_A11SecParentFunctionalityDescription, P00243_A8SecFunctionalityDescription, P00243_A9SecFunctionalityType, P00243_A3SecFunctionalityKey
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV35SecFunctionalityType ;
   private byte A9SecFunctionalityType ;
   private short AV50SecRoleId ;
   private short A4SecRoleId ;
   private short Gx_err ;
   private int AV57GXV1 ;
   private int AV53TFSecFunctionalityType_Sels_size ;
   private long A1SecFunctionalityId ;
   private long A2SecParentFunctionalityId ;
   private long AV29count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk242 ;
   private boolean n2SecParentFunctionalityId ;
   private boolean brk244 ;
   private String AV23OptionsJson ;
   private String AV26OptionsDescJson ;
   private String AV28OptionIndexesJson ;
   private String AV52TFSecFunctionalityType_SelsJson ;
   private String AV19DDOName ;
   private String AV17SearchTxt ;
   private String AV18SearchTxtTo ;
   private String AV54FilterFullText ;
   private String AV10TFSecFunctionalityKey ;
   private String AV11TFSecFunctionalityKey_Sel ;
   private String AV15TFSecParentFunctionalityDescription ;
   private String AV16TFSecParentFunctionalityDescription_Sel ;
   private String lV54FilterFullText ;
   private String lV10TFSecFunctionalityKey ;
   private String lV15TFSecParentFunctionalityDescription ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String AV21Option ;
   private GXSimpleCollection<Byte> AV53TFSecFunctionalityType_Sels ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private long[] P00242_A1SecFunctionalityId ;
   private long[] P00242_A2SecParentFunctionalityId ;
   private boolean[] P00242_n2SecParentFunctionalityId ;
   private short[] P00242_A4SecRoleId ;
   private String[] P00242_A3SecFunctionalityKey ;
   private String[] P00242_A11SecParentFunctionalityDescription ;
   private String[] P00242_A8SecFunctionalityDescription ;
   private byte[] P00242_A9SecFunctionalityType ;
   private long[] P00243_A1SecFunctionalityId ;
   private long[] P00243_A2SecParentFunctionalityId ;
   private boolean[] P00243_n2SecParentFunctionalityId ;
   private short[] P00243_A4SecRoleId ;
   private String[] P00243_A11SecParentFunctionalityDescription ;
   private String[] P00243_A8SecFunctionalityDescription ;
   private byte[] P00243_A9SecFunctionalityType ;
   private String[] P00243_A3SecFunctionalityKey ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV51WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secrolesecfunctionalityrolewcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00242( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV53TFSecFunctionalityType_Sels ,
                                          String AV54FilterFullText ,
                                          byte AV35SecFunctionalityType ,
                                          String AV11TFSecFunctionalityKey_Sel ,
                                          String AV10TFSecFunctionalityKey ,
                                          int AV53TFSecFunctionalityType_Sels_size ,
                                          String AV16TFSecParentFunctionalityDescription_Sel ,
                                          String AV15TFSecParentFunctionalityDescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV50SecRoleId ,
                                          short A4SecRoleId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[SecFunctionalityId], T2.[SecParentFunctionalityId] AS SecParentFunctionalityId, T1.[SecRoleId], T2.[SecFunctionalityKey], T3.[SecFunctionalityDescription]" ;
      scmdbuf += " AS SecParentFunctionalityDescription, T2.[SecFunctionalityDescription], T2.[SecFunctionalityType] FROM (([SecFunctionalityRole] T1 INNER JOIN [SecFunctionality]" ;
      scmdbuf += " T2 ON T2.[SecFunctionalityId] = T1.[SecFunctionalityId]) LEFT JOIN [SecFunctionality] T3 ON T3.[SecFunctionalityId] = T2.[SecParentFunctionalityId])" ;
      addWhere(sWhereString, "(T1.[SecRoleId] = ?)");
      if ( ! (GXutil.strcmp("", AV54FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( T2.[SecFunctionalityKey] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?) or ( T3.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (0==AV35SecFunctionalityType) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityType] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV11TFSecFunctionalityKey_Sel)==0) && ( ! (GXutil.strcmp("", AV10TFSecFunctionalityKey)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV11TFSecFunctionalityKey_Sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV53TFSecFunctionalityType_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV53TFSecFunctionalityType_Sels, "T2.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV16TFSecParentFunctionalityDescription_Sel)==0) && ( ! (GXutil.strcmp("", AV15TFSecParentFunctionalityDescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV16TFSecParentFunctionalityDescription_Sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SecRoleId], T2.[SecFunctionalityKey]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00243( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV53TFSecFunctionalityType_Sels ,
                                          String AV54FilterFullText ,
                                          byte AV35SecFunctionalityType ,
                                          String AV11TFSecFunctionalityKey_Sel ,
                                          String AV10TFSecFunctionalityKey ,
                                          int AV53TFSecFunctionalityType_Sels_size ,
                                          String AV16TFSecParentFunctionalityDescription_Sel ,
                                          String AV15TFSecParentFunctionalityDescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV50SecRoleId ,
                                          short A4SecRoleId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[14];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.[SecFunctionalityId], T2.[SecParentFunctionalityId] AS SecParentFunctionalityId, T1.[SecRoleId], T3.[SecFunctionalityDescription] AS SecParentFunctionalityDescription," ;
      scmdbuf += " T2.[SecFunctionalityDescription], T2.[SecFunctionalityType], T2.[SecFunctionalityKey] FROM (([SecFunctionalityRole] T1 INNER JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId]" ;
      scmdbuf += " = T1.[SecFunctionalityId]) LEFT JOIN [SecFunctionality] T3 ON T3.[SecFunctionalityId] = T2.[SecParentFunctionalityId])" ;
      addWhere(sWhereString, "(T1.[SecRoleId] = ?)");
      if ( ! (GXutil.strcmp("", AV54FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( T2.[SecFunctionalityKey] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?) or ( T3.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
         GXv_int7[5] = (byte)(1) ;
         GXv_int7[6] = (byte)(1) ;
         GXv_int7[7] = (byte)(1) ;
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (0==AV35SecFunctionalityType) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityType] = ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV11TFSecFunctionalityKey_Sel)==0) && ( ! (GXutil.strcmp("", AV10TFSecFunctionalityKey)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV11TFSecFunctionalityKey_Sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( AV53TFSecFunctionalityType_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV53TFSecFunctionalityType_Sels, "T2.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV16TFSecParentFunctionalityDescription_Sel)==0) && ( ! (GXutil.strcmp("", AV15TFSecParentFunctionalityDescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV16TFSecParentFunctionalityDescription_Sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SecRoleId], T3.[SecFunctionalityDescription]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P00242(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).byteValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() );
            case 1 :
                  return conditional_P00243(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).byteValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00242", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00243", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
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
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
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
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
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
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
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
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
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

