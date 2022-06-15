package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class petitoriosubcategwwgetfilterdata extends GXProcedure
{
   public petitoriosubcategwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitoriosubcategwwgetfilterdata.class ), "" );
   }

   public petitoriosubcategwwgetfilterdata( int remoteHandle ,
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
      petitoriosubcategwwgetfilterdata.this.aP5 = new String[] {""};
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
      petitoriosubcategwwgetfilterdata.this.AV21DDOName = aP0;
      petitoriosubcategwwgetfilterdata.this.AV19SearchTxt = aP1;
      petitoriosubcategwwgetfilterdata.this.AV20SearchTxtTo = aP2;
      petitoriosubcategwwgetfilterdata.this.aP3 = aP3;
      petitoriosubcategwwgetfilterdata.this.aP4 = aP4;
      petitoriosubcategwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorioSubCateg", GXv_boolean2) ;
      petitoriosubcategwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_PETITORIOCATEGNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADPETITORIOCATEGNOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_PETITORIOSUBCATEGNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADPETITORIOSUBCATEGNOMBREOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV25OptionsJson = AV24Options.toJSonString(false) ;
      AV28OptionsDescJson = AV27OptionsDesc.toJSonString(false) ;
      AV30OptionIndexesJson = AV29OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV32Session.getValue("PetitorioSubCategWWGridState"), "") == 0 )
      {
         AV34GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PetitorioSubCategWWGridState"), null, null);
      }
      else
      {
         AV34GridState.fromxml(AV32Session.getValue("PetitorioSubCategWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV35GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV37FilterFullText = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGID") == 0 )
         {
            AV11TFPetitorioSubCategId = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPetitorioSubCategId_To = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGID") == 0 )
         {
            AV13TFPetitorioCategId = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFPetitorioCategId_To = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGNOMBRE") == 0 )
         {
            AV15TFPetitorioCategNombre = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGNOMBRE_SEL") == 0 )
         {
            AV16TFPetitorioCategNombre_Sel = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGNOMBRE") == 0 )
         {
            AV17TFPetitorioSubCategNombre = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGNOMBRE_SEL") == 0 )
         {
            AV18TFPetitorioSubCategNombre_Sel = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPETITORIOCATEGNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV15TFPetitorioCategNombre = AV19SearchTxt ;
      AV16TFPetitorioCategNombre_Sel = "" ;
      AV42Petitoriosubcategwwds_1_filterfulltext = AV37FilterFullText ;
      AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid = AV11TFPetitorioSubCategId ;
      AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to = AV12TFPetitorioSubCategId_To ;
      AV45Petitoriosubcategwwds_4_tfpetitoriocategid = AV13TFPetitorioCategId ;
      AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to = AV14TFPetitorioCategId_To ;
      AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre = AV15TFPetitorioCategNombre ;
      AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel = AV16TFPetitorioCategNombre_Sel ;
      AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = AV17TFPetitorioSubCategNombre ;
      AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel = AV18TFPetitorioSubCategNombre_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV42Petitoriosubcategwwds_1_filterfulltext ,
                                           Short.valueOf(AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to) ,
                                           Short.valueOf(AV45Petitoriosubcategwwds_4_tfpetitoriocategid) ,
                                           Short.valueOf(AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to) ,
                                           AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ,
                                           AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre ,
                                           AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ,
                                           AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           A266PetitorioCategNombre ,
                                           A265PetitorioSubCategNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV42Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV42Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV42Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV42Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV47Petitoriosubcategwwds_6_tfpetitoriocategnombre = GXutil.concat( GXutil.rtrim( AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre), "%", "") ;
      lV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = GXutil.concat( GXutil.rtrim( AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre), "%", "") ;
      /* Using cursor P003H2 */
      pr_default.execute(0, new Object[] {lV42Petitoriosubcategwwds_1_filterfulltext, lV42Petitoriosubcategwwds_1_filterfulltext, lV42Petitoriosubcategwwds_1_filterfulltext, lV42Petitoriosubcategwwds_1_filterfulltext, Short.valueOf(AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid), Short.valueOf(AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to), Short.valueOf(AV45Petitoriosubcategwwds_4_tfpetitoriocategid), Short.valueOf(AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to), lV47Petitoriosubcategwwds_6_tfpetitoriocategnombre, AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel, lV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre, AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3H2 = false ;
         A49PetitorioCategId = P003H2_A49PetitorioCategId[0] ;
         A48PetitorioSubCategId = P003H2_A48PetitorioSubCategId[0] ;
         A265PetitorioSubCategNombre = P003H2_A265PetitorioSubCategNombre[0] ;
         A266PetitorioCategNombre = P003H2_A266PetitorioCategNombre[0] ;
         A266PetitorioCategNombre = P003H2_A266PetitorioCategNombre[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P003H2_A49PetitorioCategId[0] == A49PetitorioCategId ) )
         {
            brk3H2 = false ;
            A48PetitorioSubCategId = P003H2_A48PetitorioSubCategId[0] ;
            AV31count = (long)(AV31count+1) ;
            brk3H2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A266PetitorioCategNombre)==0) )
         {
            AV23Option = A266PetitorioCategNombre ;
            AV22InsertIndex = 1 ;
            while ( ( AV22InsertIndex <= AV24Options.size() ) && ( GXutil.strcmp((String)AV24Options.elementAt(-1+AV22InsertIndex), AV23Option) < 0 ) )
            {
               AV22InsertIndex = (int)(AV22InsertIndex+1) ;
            }
            AV24Options.add(AV23Option, AV22InsertIndex);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), AV22InsertIndex);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3H2 )
         {
            brk3H2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPETITORIOSUBCATEGNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV17TFPetitorioSubCategNombre = AV19SearchTxt ;
      AV18TFPetitorioSubCategNombre_Sel = "" ;
      AV42Petitoriosubcategwwds_1_filterfulltext = AV37FilterFullText ;
      AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid = AV11TFPetitorioSubCategId ;
      AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to = AV12TFPetitorioSubCategId_To ;
      AV45Petitoriosubcategwwds_4_tfpetitoriocategid = AV13TFPetitorioCategId ;
      AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to = AV14TFPetitorioCategId_To ;
      AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre = AV15TFPetitorioCategNombre ;
      AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel = AV16TFPetitorioCategNombre_Sel ;
      AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = AV17TFPetitorioSubCategNombre ;
      AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel = AV18TFPetitorioSubCategNombre_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV42Petitoriosubcategwwds_1_filterfulltext ,
                                           Short.valueOf(AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to) ,
                                           Short.valueOf(AV45Petitoriosubcategwwds_4_tfpetitoriocategid) ,
                                           Short.valueOf(AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to) ,
                                           AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ,
                                           AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre ,
                                           AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ,
                                           AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           A266PetitorioCategNombre ,
                                           A265PetitorioSubCategNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV42Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV42Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV42Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV42Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV47Petitoriosubcategwwds_6_tfpetitoriocategnombre = GXutil.concat( GXutil.rtrim( AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre), "%", "") ;
      lV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = GXutil.concat( GXutil.rtrim( AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre), "%", "") ;
      /* Using cursor P003H3 */
      pr_default.execute(1, new Object[] {lV42Petitoriosubcategwwds_1_filterfulltext, lV42Petitoriosubcategwwds_1_filterfulltext, lV42Petitoriosubcategwwds_1_filterfulltext, lV42Petitoriosubcategwwds_1_filterfulltext, Short.valueOf(AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid), Short.valueOf(AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to), Short.valueOf(AV45Petitoriosubcategwwds_4_tfpetitoriocategid), Short.valueOf(AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to), lV47Petitoriosubcategwwds_6_tfpetitoriocategnombre, AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel, lV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre, AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3H4 = false ;
         A265PetitorioSubCategNombre = P003H3_A265PetitorioSubCategNombre[0] ;
         A49PetitorioCategId = P003H3_A49PetitorioCategId[0] ;
         A48PetitorioSubCategId = P003H3_A48PetitorioSubCategId[0] ;
         A266PetitorioCategNombre = P003H3_A266PetitorioCategNombre[0] ;
         A266PetitorioCategNombre = P003H3_A266PetitorioCategNombre[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003H3_A265PetitorioSubCategNombre[0], A265PetitorioSubCategNombre) == 0 ) )
         {
            brk3H4 = false ;
            A48PetitorioSubCategId = P003H3_A48PetitorioSubCategId[0] ;
            AV31count = (long)(AV31count+1) ;
            brk3H4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A265PetitorioSubCategNombre)==0) )
         {
            AV23Option = A265PetitorioSubCategNombre ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3H4 )
         {
            brk3H4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = petitoriosubcategwwgetfilterdata.this.AV25OptionsJson;
      this.aP4[0] = petitoriosubcategwwgetfilterdata.this.AV28OptionsDescJson;
      this.aP5[0] = petitoriosubcategwwgetfilterdata.this.AV30OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25OptionsJson = "" ;
      AV28OptionsDescJson = "" ;
      AV30OptionIndexesJson = "" ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV32Session = httpContext.getWebSession();
      AV34GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV35GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37FilterFullText = "" ;
      AV15TFPetitorioCategNombre = "" ;
      AV16TFPetitorioCategNombre_Sel = "" ;
      AV17TFPetitorioSubCategNombre = "" ;
      AV18TFPetitorioSubCategNombre_Sel = "" ;
      A266PetitorioCategNombre = "" ;
      AV42Petitoriosubcategwwds_1_filterfulltext = "" ;
      AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre = "" ;
      AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel = "" ;
      AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = "" ;
      AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel = "" ;
      scmdbuf = "" ;
      lV42Petitoriosubcategwwds_1_filterfulltext = "" ;
      lV47Petitoriosubcategwwds_6_tfpetitoriocategnombre = "" ;
      lV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = "" ;
      A265PetitorioSubCategNombre = "" ;
      P003H2_A49PetitorioCategId = new short[1] ;
      P003H2_A48PetitorioSubCategId = new short[1] ;
      P003H2_A265PetitorioSubCategNombre = new String[] {""} ;
      P003H2_A266PetitorioCategNombre = new String[] {""} ;
      AV23Option = "" ;
      P003H3_A265PetitorioSubCategNombre = new String[] {""} ;
      P003H3_A49PetitorioCategId = new short[1] ;
      P003H3_A48PetitorioSubCategId = new short[1] ;
      P003H3_A266PetitorioCategNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriosubcategwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003H2_A49PetitorioCategId, P003H2_A48PetitorioSubCategId, P003H2_A265PetitorioSubCategNombre, P003H2_A266PetitorioCategNombre
            }
            , new Object[] {
            P003H3_A265PetitorioSubCategNombre, P003H3_A49PetitorioCategId, P003H3_A48PetitorioSubCategId, P003H3_A266PetitorioCategNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFPetitorioSubCategId ;
   private short AV12TFPetitorioSubCategId_To ;
   private short AV13TFPetitorioCategId ;
   private short AV14TFPetitorioCategId_To ;
   private short AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid ;
   private short AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to ;
   private short AV45Petitoriosubcategwwds_4_tfpetitoriocategid ;
   private short AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to ;
   private short A48PetitorioSubCategId ;
   private short A49PetitorioCategId ;
   private short Gx_err ;
   private int AV40GXV1 ;
   private int AV22InsertIndex ;
   private long AV31count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3H2 ;
   private boolean brk3H4 ;
   private String AV25OptionsJson ;
   private String AV28OptionsDescJson ;
   private String AV30OptionIndexesJson ;
   private String AV21DDOName ;
   private String AV19SearchTxt ;
   private String AV20SearchTxtTo ;
   private String AV37FilterFullText ;
   private String AV15TFPetitorioCategNombre ;
   private String AV16TFPetitorioCategNombre_Sel ;
   private String AV17TFPetitorioSubCategNombre ;
   private String AV18TFPetitorioSubCategNombre_Sel ;
   private String A266PetitorioCategNombre ;
   private String AV42Petitoriosubcategwwds_1_filterfulltext ;
   private String AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre ;
   private String AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ;
   private String AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ;
   private String AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ;
   private String lV42Petitoriosubcategwwds_1_filterfulltext ;
   private String lV47Petitoriosubcategwwds_6_tfpetitoriocategnombre ;
   private String lV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ;
   private String A265PetitorioSubCategNombre ;
   private String AV23Option ;
   private com.genexus.webpanels.WebSession AV32Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P003H2_A49PetitorioCategId ;
   private short[] P003H2_A48PetitorioSubCategId ;
   private String[] P003H2_A265PetitorioSubCategNombre ;
   private String[] P003H2_A266PetitorioCategNombre ;
   private String[] P003H3_A265PetitorioSubCategNombre ;
   private short[] P003H3_A49PetitorioCategId ;
   private short[] P003H3_A48PetitorioSubCategId ;
   private String[] P003H3_A266PetitorioCategNombre ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV27OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV34GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV35GridStateFilterValue ;
}

final  class petitoriosubcategwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV42Petitoriosubcategwwds_1_filterfulltext ,
                                          short AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid ,
                                          short AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to ,
                                          short AV45Petitoriosubcategwwds_4_tfpetitoriocategid ,
                                          short AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to ,
                                          String AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ,
                                          String AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre ,
                                          String AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ,
                                          String AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ,
                                          short A48PetitorioSubCategId ,
                                          short A49PetitorioCategId ,
                                          String A266PetitorioCategNombre ,
                                          String A265PetitorioSubCategNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[12];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioCategId], T1.[PetitorioSubCategId], T1.[PetitorioSubCategNombre], T2.[PetitorioCategNombre] FROM ([PetitorioSubCateg] T1 INNER JOIN [PetitorioCateg]" ;
      scmdbuf += " T2 ON T2.[PetitorioCategId] = T1.[PetitorioCategId])" ;
      if ( ! (GXutil.strcmp("", AV42Petitoriosubcategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( T2.[PetitorioCategNombre] like '%' + ?) or ( T1.[PetitorioSubCategNombre] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (0==AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (0==AV45Petitoriosubcategwwds_4_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (0==AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategNombre] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategNombre] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategNombre] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategNombre] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PetitorioCategId]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003H3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV42Petitoriosubcategwwds_1_filterfulltext ,
                                          short AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid ,
                                          short AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to ,
                                          short AV45Petitoriosubcategwwds_4_tfpetitoriocategid ,
                                          short AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to ,
                                          String AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ,
                                          String AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre ,
                                          String AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ,
                                          String AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ,
                                          short A48PetitorioSubCategId ,
                                          short A49PetitorioCategId ,
                                          String A266PetitorioCategNombre ,
                                          String A265PetitorioSubCategNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[12];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioSubCategNombre], T1.[PetitorioCategId], T1.[PetitorioSubCategId], T2.[PetitorioCategNombre] FROM ([PetitorioSubCateg] T1 INNER JOIN [PetitorioCateg]" ;
      scmdbuf += " T2 ON T2.[PetitorioCategId] = T1.[PetitorioCategId])" ;
      if ( ! (GXutil.strcmp("", AV42Petitoriosubcategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( T2.[PetitorioCategNombre] like '%' + ?) or ( T1.[PetitorioSubCategNombre] like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
         GXv_int6[3] = (byte)(1) ;
      }
      if ( ! (0==AV43Petitoriosubcategwwds_2_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int6[4] = (byte)(1) ;
      }
      if ( ! (0==AV44Petitoriosubcategwwds_3_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int6[5] = (byte)(1) ;
      }
      if ( ! (0==AV45Petitoriosubcategwwds_4_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int6[6] = (byte)(1) ;
      }
      if ( ! (0==AV46Petitoriosubcategwwds_5_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int6[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV47Petitoriosubcategwwds_6_tfpetitoriocategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategNombre] like ?)");
      }
      else
      {
         GXv_int6[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategNombre] = ?)");
      }
      else
      {
         GXv_int6[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV49Petitoriosubcategwwds_8_tfpetitoriosubcategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategNombre] like ?)");
      }
      else
      {
         GXv_int6[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategNombre] = ?)");
      }
      else
      {
         GXv_int6[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PetitorioSubCategNombre]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P003H2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] );
            case 1 :
                  return conditional_P003H3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003H3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
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
                  stmt.setVarchar(sIdx, (String)parms[20], 200);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
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
                  stmt.setVarchar(sIdx, (String)parms[20], 200);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
      }
   }

}

