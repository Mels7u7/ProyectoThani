package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sedewwgetfilterdata extends GXProcedure
{
   public sedewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sedewwgetfilterdata.class ), "" );
   }

   public sedewwgetfilterdata( int remoteHandle ,
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
      sedewwgetfilterdata.this.aP5 = new String[] {""};
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
      sedewwgetfilterdata.this.AV37DDOName = aP0;
      sedewwgetfilterdata.this.AV35SearchTxt = aP1;
      sedewwgetfilterdata.this.AV36SearchTxtTo = aP2;
      sedewwgetfilterdata.this.aP3 = aP3;
      sedewwgetfilterdata.this.aP4 = aP4;
      sedewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede", GXv_boolean2) ;
      sedewwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_SEDENOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADSEDENOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CLINICANOMBRECOMERCIAL") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICANOMBRECOMERCIALOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_UBIGEOCODE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEOCODEOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_UBIGEONOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEONOMBREOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_SEDEDIRECCION") == 0 )
         {
            /* Execute user subroutine: 'LOADSEDEDIRECCIONOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_SEDECORREO") == 0 )
         {
            /* Execute user subroutine: 'LOADSEDECORREOOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV41OptionsJson = AV40Options.toJSonString(false) ;
      AV44OptionsDescJson = AV43OptionsDesc.toJSonString(false) ;
      AV46OptionIndexesJson = AV45OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV48Session.getValue("SedeWWGridState"), "") == 0 )
      {
         AV50GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SedeWWGridState"), null, null);
      }
      else
      {
         AV50GridState.fromxml(AV48Session.getValue("SedeWWGridState"), null, null);
      }
      AV56GXV1 = 1 ;
      while ( AV56GXV1 <= AV50GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV51GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV50GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV56GXV1));
         if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV53FilterFullText = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEID") == 0 )
         {
            AV11TFSedeId = (short)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFSedeId_To = (short)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDENOMBRE") == 0 )
         {
            AV13TFSedeNombre = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDENOMBRE_SEL") == 0 )
         {
            AV14TFSedeNombre_Sel = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAID") == 0 )
         {
            AV15TFClinicaId = (short)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV16TFClinicaId_To = (short)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICARUC") == 0 )
         {
            AV17TFClinicaRUC = GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV18TFClinicaRUC_To = GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL") == 0 )
         {
            AV19TFClinicaNombreComercial = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL_SEL") == 0 )
         {
            AV20TFClinicaNombreComercial_Sel = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV21TFUbigeoCode = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV22TFUbigeoCode_Sel = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV23TFUbigeoNombre = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV24TFUbigeoNombre_Sel = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEDIRECCION") == 0 )
         {
            AV25TFSedeDireccion = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEDIRECCION_SEL") == 0 )
         {
            AV26TFSedeDireccion_Sel = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDECORREO") == 0 )
         {
            AV27TFSedeCorreo = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDECORREO_SEL") == 0 )
         {
            AV28TFSedeCorreo_Sel = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEESTADO_SEL") == 0 )
         {
            AV29TFSedeEstado_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV30TFSedeEstado_Sels.fromJSonString(AV29TFSedeEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDETIPO_SEL") == 0 )
         {
            AV31TFSedeTipo_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV32TFSedeTipo_Sels.fromJSonString(AV31TFSedeTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDESECTOR_SEL") == 0 )
         {
            AV33TFSedeSector_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV34TFSedeSector_Sels.fromJSonString(AV33TFSedeSector_SelsJson, null);
         }
         AV56GXV1 = (int)(AV56GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSEDENOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV13TFSedeNombre = AV35SearchTxt ;
      AV14TFSedeNombre_Sel = "" ;
      AV58Sedewwds_1_filterfulltext = AV53FilterFullText ;
      AV59Sedewwds_2_tfsedeid = AV11TFSedeId ;
      AV60Sedewwds_3_tfsedeid_to = AV12TFSedeId_To ;
      AV61Sedewwds_4_tfsedenombre = AV13TFSedeNombre ;
      AV62Sedewwds_5_tfsedenombre_sel = AV14TFSedeNombre_Sel ;
      AV63Sedewwds_6_tfclinicaid = AV15TFClinicaId ;
      AV64Sedewwds_7_tfclinicaid_to = AV16TFClinicaId_To ;
      AV65Sedewwds_8_tfclinicaruc = AV17TFClinicaRUC ;
      AV66Sedewwds_9_tfclinicaruc_to = AV18TFClinicaRUC_To ;
      AV67Sedewwds_10_tfclinicanombrecomercial = AV19TFClinicaNombreComercial ;
      AV68Sedewwds_11_tfclinicanombrecomercial_sel = AV20TFClinicaNombreComercial_Sel ;
      AV69Sedewwds_12_tfubigeocode = AV21TFUbigeoCode ;
      AV70Sedewwds_13_tfubigeocode_sel = AV22TFUbigeoCode_Sel ;
      AV71Sedewwds_14_tfubigeonombre = AV23TFUbigeoNombre ;
      AV72Sedewwds_15_tfubigeonombre_sel = AV24TFUbigeoNombre_Sel ;
      AV73Sedewwds_16_tfsededireccion = AV25TFSedeDireccion ;
      AV74Sedewwds_17_tfsededireccion_sel = AV26TFSedeDireccion_Sel ;
      AV75Sedewwds_18_tfsedecorreo = AV27TFSedeCorreo ;
      AV76Sedewwds_19_tfsedecorreo_sel = AV28TFSedeCorreo_Sel ;
      AV77Sedewwds_20_tfsedeestado_sels = AV30TFSedeEstado_Sels ;
      AV78Sedewwds_21_tfsedetipo_sels = AV32TFSedeTipo_Sels ;
      AV79Sedewwds_22_tfsedesector_sels = AV34TFSedeSector_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV77Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV78Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV79Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV59Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV60Sedewwds_3_tfsedeid_to) ,
                                           AV62Sedewwds_5_tfsedenombre_sel ,
                                           AV61Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV63Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV64Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV65Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to) ,
                                           AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV67Sedewwds_10_tfclinicanombrecomercial ,
                                           AV70Sedewwds_13_tfubigeocode_sel ,
                                           AV69Sedewwds_12_tfubigeocode ,
                                           AV72Sedewwds_15_tfubigeonombre_sel ,
                                           AV71Sedewwds_14_tfubigeonombre ,
                                           AV74Sedewwds_17_tfsededireccion_sel ,
                                           AV73Sedewwds_16_tfsededireccion ,
                                           AV76Sedewwds_19_tfsedecorreo_sel ,
                                           AV75Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV77Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV78Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV79Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           AV58Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV61Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV61Sedewwds_4_tfsedenombre), "%", "") ;
      lV67Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV67Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV69Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV69Sedewwds_12_tfubigeocode), 10, "%") ;
      lV71Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV71Sedewwds_14_tfubigeonombre), "%", "") ;
      lV73Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV73Sedewwds_16_tfsededireccion), "%", "") ;
      lV75Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV75Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor P003V2 */
      pr_default.execute(0, new Object[] {AV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, Short.valueOf(AV59Sedewwds_2_tfsedeid), Short.valueOf(AV60Sedewwds_3_tfsedeid_to), lV61Sedewwds_4_tfsedenombre, AV62Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV63Sedewwds_6_tfclinicaid), Short.valueOf(AV64Sedewwds_7_tfclinicaid_to), Long.valueOf(AV65Sedewwds_8_tfclinicaruc), Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to), lV67Sedewwds_10_tfclinicanombrecomercial, AV68Sedewwds_11_tfclinicanombrecomercial_sel, lV69Sedewwds_12_tfubigeocode, AV70Sedewwds_13_tfubigeocode_sel, lV71Sedewwds_14_tfubigeonombre, AV72Sedewwds_15_tfubigeonombre_sel, lV73Sedewwds_16_tfsededireccion, AV74Sedewwds_17_tfsededireccion_sel, lV75Sedewwds_18_tfsedecorreo, AV76Sedewwds_19_tfsedecorreo_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3V2 = false ;
         A75SedeNombre = P003V2_A75SedeNombre[0] ;
         A118ClinicaRUC = P003V2_A118ClinicaRUC[0] ;
         A28ClinicaId = P003V2_A28ClinicaId[0] ;
         A30SedeId = P003V2_A30SedeId[0] ;
         A280SedeSector = P003V2_A280SedeSector[0] ;
         A279SedeTipo = P003V2_A279SedeTipo[0] ;
         A278SedeEstado = P003V2_A278SedeEstado[0] ;
         A277SedeCorreo = P003V2_A277SedeCorreo[0] ;
         A276SedeDireccion = P003V2_A276SedeDireccion[0] ;
         A185UbigeoNombre = P003V2_A185UbigeoNombre[0] ;
         A44UbigeoCode = P003V2_A44UbigeoCode[0] ;
         A116ClinicaNombreComercial = P003V2_A116ClinicaNombreComercial[0] ;
         A186UbigeoDepartamento = P003V2_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V2_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V2_A188UbigeoDistrito[0] ;
         A118ClinicaRUC = P003V2_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = P003V2_A116ClinicaNombreComercial[0] ;
         A185UbigeoNombre = P003V2_A185UbigeoNombre[0] ;
         A186UbigeoDepartamento = P003V2_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V2_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V2_A188UbigeoDistrito[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P003V2_A75SedeNombre[0], A75SedeNombre) == 0 ) )
         {
            brk3V2 = false ;
            A30SedeId = P003V2_A30SedeId[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A75SedeNombre)==0) )
         {
            AV39Option = A75SedeNombre ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V2 )
         {
            brk3V2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCLINICANOMBRECOMERCIALOPTIONS' Routine */
      returnInSub = false ;
      AV19TFClinicaNombreComercial = AV35SearchTxt ;
      AV20TFClinicaNombreComercial_Sel = "" ;
      AV58Sedewwds_1_filterfulltext = AV53FilterFullText ;
      AV59Sedewwds_2_tfsedeid = AV11TFSedeId ;
      AV60Sedewwds_3_tfsedeid_to = AV12TFSedeId_To ;
      AV61Sedewwds_4_tfsedenombre = AV13TFSedeNombre ;
      AV62Sedewwds_5_tfsedenombre_sel = AV14TFSedeNombre_Sel ;
      AV63Sedewwds_6_tfclinicaid = AV15TFClinicaId ;
      AV64Sedewwds_7_tfclinicaid_to = AV16TFClinicaId_To ;
      AV65Sedewwds_8_tfclinicaruc = AV17TFClinicaRUC ;
      AV66Sedewwds_9_tfclinicaruc_to = AV18TFClinicaRUC_To ;
      AV67Sedewwds_10_tfclinicanombrecomercial = AV19TFClinicaNombreComercial ;
      AV68Sedewwds_11_tfclinicanombrecomercial_sel = AV20TFClinicaNombreComercial_Sel ;
      AV69Sedewwds_12_tfubigeocode = AV21TFUbigeoCode ;
      AV70Sedewwds_13_tfubigeocode_sel = AV22TFUbigeoCode_Sel ;
      AV71Sedewwds_14_tfubigeonombre = AV23TFUbigeoNombre ;
      AV72Sedewwds_15_tfubigeonombre_sel = AV24TFUbigeoNombre_Sel ;
      AV73Sedewwds_16_tfsededireccion = AV25TFSedeDireccion ;
      AV74Sedewwds_17_tfsededireccion_sel = AV26TFSedeDireccion_Sel ;
      AV75Sedewwds_18_tfsedecorreo = AV27TFSedeCorreo ;
      AV76Sedewwds_19_tfsedecorreo_sel = AV28TFSedeCorreo_Sel ;
      AV77Sedewwds_20_tfsedeestado_sels = AV30TFSedeEstado_Sels ;
      AV78Sedewwds_21_tfsedetipo_sels = AV32TFSedeTipo_Sels ;
      AV79Sedewwds_22_tfsedesector_sels = AV34TFSedeSector_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV77Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV78Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV79Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV59Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV60Sedewwds_3_tfsedeid_to) ,
                                           AV62Sedewwds_5_tfsedenombre_sel ,
                                           AV61Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV63Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV64Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV65Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to) ,
                                           AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV67Sedewwds_10_tfclinicanombrecomercial ,
                                           AV70Sedewwds_13_tfubigeocode_sel ,
                                           AV69Sedewwds_12_tfubigeocode ,
                                           AV72Sedewwds_15_tfubigeonombre_sel ,
                                           AV71Sedewwds_14_tfubigeonombre ,
                                           AV74Sedewwds_17_tfsededireccion_sel ,
                                           AV73Sedewwds_16_tfsededireccion ,
                                           AV76Sedewwds_19_tfsedecorreo_sel ,
                                           AV75Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV77Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV78Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV79Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           AV58Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV61Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV61Sedewwds_4_tfsedenombre), "%", "") ;
      lV67Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV67Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV69Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV69Sedewwds_12_tfubigeocode), 10, "%") ;
      lV71Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV71Sedewwds_14_tfubigeonombre), "%", "") ;
      lV73Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV73Sedewwds_16_tfsededireccion), "%", "") ;
      lV75Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV75Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor P003V3 */
      pr_default.execute(1, new Object[] {AV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, Short.valueOf(AV59Sedewwds_2_tfsedeid), Short.valueOf(AV60Sedewwds_3_tfsedeid_to), lV61Sedewwds_4_tfsedenombre, AV62Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV63Sedewwds_6_tfclinicaid), Short.valueOf(AV64Sedewwds_7_tfclinicaid_to), Long.valueOf(AV65Sedewwds_8_tfclinicaruc), Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to), lV67Sedewwds_10_tfclinicanombrecomercial, AV68Sedewwds_11_tfclinicanombrecomercial_sel, lV69Sedewwds_12_tfubigeocode, AV70Sedewwds_13_tfubigeocode_sel, lV71Sedewwds_14_tfubigeonombre, AV72Sedewwds_15_tfubigeonombre_sel, lV73Sedewwds_16_tfsededireccion, AV74Sedewwds_17_tfsededireccion_sel, lV75Sedewwds_18_tfsedecorreo, AV76Sedewwds_19_tfsedecorreo_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3V4 = false ;
         A116ClinicaNombreComercial = P003V3_A116ClinicaNombreComercial[0] ;
         A118ClinicaRUC = P003V3_A118ClinicaRUC[0] ;
         A28ClinicaId = P003V3_A28ClinicaId[0] ;
         A30SedeId = P003V3_A30SedeId[0] ;
         A280SedeSector = P003V3_A280SedeSector[0] ;
         A279SedeTipo = P003V3_A279SedeTipo[0] ;
         A278SedeEstado = P003V3_A278SedeEstado[0] ;
         A277SedeCorreo = P003V3_A277SedeCorreo[0] ;
         A276SedeDireccion = P003V3_A276SedeDireccion[0] ;
         A185UbigeoNombre = P003V3_A185UbigeoNombre[0] ;
         A44UbigeoCode = P003V3_A44UbigeoCode[0] ;
         A75SedeNombre = P003V3_A75SedeNombre[0] ;
         A186UbigeoDepartamento = P003V3_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V3_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V3_A188UbigeoDistrito[0] ;
         A116ClinicaNombreComercial = P003V3_A116ClinicaNombreComercial[0] ;
         A118ClinicaRUC = P003V3_A118ClinicaRUC[0] ;
         A185UbigeoNombre = P003V3_A185UbigeoNombre[0] ;
         A186UbigeoDepartamento = P003V3_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V3_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V3_A188UbigeoDistrito[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003V3_A116ClinicaNombreComercial[0], A116ClinicaNombreComercial) == 0 ) )
         {
            brk3V4 = false ;
            A28ClinicaId = P003V3_A28ClinicaId[0] ;
            A30SedeId = P003V3_A30SedeId[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A116ClinicaNombreComercial)==0) )
         {
            AV39Option = A116ClinicaNombreComercial ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V4 )
         {
            brk3V4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADUBIGEOCODEOPTIONS' Routine */
      returnInSub = false ;
      AV21TFUbigeoCode = AV35SearchTxt ;
      AV22TFUbigeoCode_Sel = "" ;
      AV58Sedewwds_1_filterfulltext = AV53FilterFullText ;
      AV59Sedewwds_2_tfsedeid = AV11TFSedeId ;
      AV60Sedewwds_3_tfsedeid_to = AV12TFSedeId_To ;
      AV61Sedewwds_4_tfsedenombre = AV13TFSedeNombre ;
      AV62Sedewwds_5_tfsedenombre_sel = AV14TFSedeNombre_Sel ;
      AV63Sedewwds_6_tfclinicaid = AV15TFClinicaId ;
      AV64Sedewwds_7_tfclinicaid_to = AV16TFClinicaId_To ;
      AV65Sedewwds_8_tfclinicaruc = AV17TFClinicaRUC ;
      AV66Sedewwds_9_tfclinicaruc_to = AV18TFClinicaRUC_To ;
      AV67Sedewwds_10_tfclinicanombrecomercial = AV19TFClinicaNombreComercial ;
      AV68Sedewwds_11_tfclinicanombrecomercial_sel = AV20TFClinicaNombreComercial_Sel ;
      AV69Sedewwds_12_tfubigeocode = AV21TFUbigeoCode ;
      AV70Sedewwds_13_tfubigeocode_sel = AV22TFUbigeoCode_Sel ;
      AV71Sedewwds_14_tfubigeonombre = AV23TFUbigeoNombre ;
      AV72Sedewwds_15_tfubigeonombre_sel = AV24TFUbigeoNombre_Sel ;
      AV73Sedewwds_16_tfsededireccion = AV25TFSedeDireccion ;
      AV74Sedewwds_17_tfsededireccion_sel = AV26TFSedeDireccion_Sel ;
      AV75Sedewwds_18_tfsedecorreo = AV27TFSedeCorreo ;
      AV76Sedewwds_19_tfsedecorreo_sel = AV28TFSedeCorreo_Sel ;
      AV77Sedewwds_20_tfsedeestado_sels = AV30TFSedeEstado_Sels ;
      AV78Sedewwds_21_tfsedetipo_sels = AV32TFSedeTipo_Sels ;
      AV79Sedewwds_22_tfsedesector_sels = AV34TFSedeSector_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV77Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV78Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV79Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV59Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV60Sedewwds_3_tfsedeid_to) ,
                                           AV62Sedewwds_5_tfsedenombre_sel ,
                                           AV61Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV63Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV64Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV65Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to) ,
                                           AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV67Sedewwds_10_tfclinicanombrecomercial ,
                                           AV70Sedewwds_13_tfubigeocode_sel ,
                                           AV69Sedewwds_12_tfubigeocode ,
                                           AV72Sedewwds_15_tfubigeonombre_sel ,
                                           AV71Sedewwds_14_tfubigeonombre ,
                                           AV74Sedewwds_17_tfsededireccion_sel ,
                                           AV73Sedewwds_16_tfsededireccion ,
                                           AV76Sedewwds_19_tfsedecorreo_sel ,
                                           AV75Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV77Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV78Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV79Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           AV58Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV61Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV61Sedewwds_4_tfsedenombre), "%", "") ;
      lV67Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV67Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV69Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV69Sedewwds_12_tfubigeocode), 10, "%") ;
      lV71Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV71Sedewwds_14_tfubigeonombre), "%", "") ;
      lV73Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV73Sedewwds_16_tfsededireccion), "%", "") ;
      lV75Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV75Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor P003V4 */
      pr_default.execute(2, new Object[] {AV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, Short.valueOf(AV59Sedewwds_2_tfsedeid), Short.valueOf(AV60Sedewwds_3_tfsedeid_to), lV61Sedewwds_4_tfsedenombre, AV62Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV63Sedewwds_6_tfclinicaid), Short.valueOf(AV64Sedewwds_7_tfclinicaid_to), Long.valueOf(AV65Sedewwds_8_tfclinicaruc), Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to), lV67Sedewwds_10_tfclinicanombrecomercial, AV68Sedewwds_11_tfclinicanombrecomercial_sel, lV69Sedewwds_12_tfubigeocode, AV70Sedewwds_13_tfubigeocode_sel, lV71Sedewwds_14_tfubigeonombre, AV72Sedewwds_15_tfubigeonombre_sel, lV73Sedewwds_16_tfsededireccion, AV74Sedewwds_17_tfsededireccion_sel, lV75Sedewwds_18_tfsedecorreo, AV76Sedewwds_19_tfsedecorreo_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk3V6 = false ;
         A44UbigeoCode = P003V4_A44UbigeoCode[0] ;
         A118ClinicaRUC = P003V4_A118ClinicaRUC[0] ;
         A28ClinicaId = P003V4_A28ClinicaId[0] ;
         A30SedeId = P003V4_A30SedeId[0] ;
         A280SedeSector = P003V4_A280SedeSector[0] ;
         A279SedeTipo = P003V4_A279SedeTipo[0] ;
         A278SedeEstado = P003V4_A278SedeEstado[0] ;
         A277SedeCorreo = P003V4_A277SedeCorreo[0] ;
         A276SedeDireccion = P003V4_A276SedeDireccion[0] ;
         A185UbigeoNombre = P003V4_A185UbigeoNombre[0] ;
         A116ClinicaNombreComercial = P003V4_A116ClinicaNombreComercial[0] ;
         A75SedeNombre = P003V4_A75SedeNombre[0] ;
         A186UbigeoDepartamento = P003V4_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V4_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V4_A188UbigeoDistrito[0] ;
         A185UbigeoNombre = P003V4_A185UbigeoNombre[0] ;
         A186UbigeoDepartamento = P003V4_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V4_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V4_A188UbigeoDistrito[0] ;
         A118ClinicaRUC = P003V4_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = P003V4_A116ClinicaNombreComercial[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P003V4_A44UbigeoCode[0], A44UbigeoCode) == 0 ) )
         {
            brk3V6 = false ;
            A30SedeId = P003V4_A30SedeId[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A44UbigeoCode)==0) )
         {
            AV39Option = A44UbigeoCode ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V6 )
         {
            brk3V6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADUBIGEONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV23TFUbigeoNombre = AV35SearchTxt ;
      AV24TFUbigeoNombre_Sel = "" ;
      AV58Sedewwds_1_filterfulltext = AV53FilterFullText ;
      AV59Sedewwds_2_tfsedeid = AV11TFSedeId ;
      AV60Sedewwds_3_tfsedeid_to = AV12TFSedeId_To ;
      AV61Sedewwds_4_tfsedenombre = AV13TFSedeNombre ;
      AV62Sedewwds_5_tfsedenombre_sel = AV14TFSedeNombre_Sel ;
      AV63Sedewwds_6_tfclinicaid = AV15TFClinicaId ;
      AV64Sedewwds_7_tfclinicaid_to = AV16TFClinicaId_To ;
      AV65Sedewwds_8_tfclinicaruc = AV17TFClinicaRUC ;
      AV66Sedewwds_9_tfclinicaruc_to = AV18TFClinicaRUC_To ;
      AV67Sedewwds_10_tfclinicanombrecomercial = AV19TFClinicaNombreComercial ;
      AV68Sedewwds_11_tfclinicanombrecomercial_sel = AV20TFClinicaNombreComercial_Sel ;
      AV69Sedewwds_12_tfubigeocode = AV21TFUbigeoCode ;
      AV70Sedewwds_13_tfubigeocode_sel = AV22TFUbigeoCode_Sel ;
      AV71Sedewwds_14_tfubigeonombre = AV23TFUbigeoNombre ;
      AV72Sedewwds_15_tfubigeonombre_sel = AV24TFUbigeoNombre_Sel ;
      AV73Sedewwds_16_tfsededireccion = AV25TFSedeDireccion ;
      AV74Sedewwds_17_tfsededireccion_sel = AV26TFSedeDireccion_Sel ;
      AV75Sedewwds_18_tfsedecorreo = AV27TFSedeCorreo ;
      AV76Sedewwds_19_tfsedecorreo_sel = AV28TFSedeCorreo_Sel ;
      AV77Sedewwds_20_tfsedeestado_sels = AV30TFSedeEstado_Sels ;
      AV78Sedewwds_21_tfsedetipo_sels = AV32TFSedeTipo_Sels ;
      AV79Sedewwds_22_tfsedesector_sels = AV34TFSedeSector_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV77Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV78Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV79Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV59Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV60Sedewwds_3_tfsedeid_to) ,
                                           AV62Sedewwds_5_tfsedenombre_sel ,
                                           AV61Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV63Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV64Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV65Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to) ,
                                           AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV67Sedewwds_10_tfclinicanombrecomercial ,
                                           AV70Sedewwds_13_tfubigeocode_sel ,
                                           AV69Sedewwds_12_tfubigeocode ,
                                           AV72Sedewwds_15_tfubigeonombre_sel ,
                                           AV71Sedewwds_14_tfubigeonombre ,
                                           AV74Sedewwds_17_tfsededireccion_sel ,
                                           AV73Sedewwds_16_tfsededireccion ,
                                           AV76Sedewwds_19_tfsedecorreo_sel ,
                                           AV75Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV77Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV78Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV79Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           AV58Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV61Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV61Sedewwds_4_tfsedenombre), "%", "") ;
      lV67Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV67Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV69Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV69Sedewwds_12_tfubigeocode), 10, "%") ;
      lV71Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV71Sedewwds_14_tfubigeonombre), "%", "") ;
      lV73Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV73Sedewwds_16_tfsededireccion), "%", "") ;
      lV75Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV75Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor P003V5 */
      pr_default.execute(3, new Object[] {AV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, Short.valueOf(AV59Sedewwds_2_tfsedeid), Short.valueOf(AV60Sedewwds_3_tfsedeid_to), lV61Sedewwds_4_tfsedenombre, AV62Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV63Sedewwds_6_tfclinicaid), Short.valueOf(AV64Sedewwds_7_tfclinicaid_to), Long.valueOf(AV65Sedewwds_8_tfclinicaruc), Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to), lV67Sedewwds_10_tfclinicanombrecomercial, AV68Sedewwds_11_tfclinicanombrecomercial_sel, lV69Sedewwds_12_tfubigeocode, AV70Sedewwds_13_tfubigeocode_sel, lV71Sedewwds_14_tfubigeonombre, AV72Sedewwds_15_tfubigeonombre_sel, lV73Sedewwds_16_tfsededireccion, AV74Sedewwds_17_tfsededireccion_sel, lV75Sedewwds_18_tfsedecorreo, AV76Sedewwds_19_tfsedecorreo_sel});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk3V8 = false ;
         A44UbigeoCode = P003V5_A44UbigeoCode[0] ;
         A118ClinicaRUC = P003V5_A118ClinicaRUC[0] ;
         A28ClinicaId = P003V5_A28ClinicaId[0] ;
         A30SedeId = P003V5_A30SedeId[0] ;
         A280SedeSector = P003V5_A280SedeSector[0] ;
         A279SedeTipo = P003V5_A279SedeTipo[0] ;
         A278SedeEstado = P003V5_A278SedeEstado[0] ;
         A277SedeCorreo = P003V5_A277SedeCorreo[0] ;
         A276SedeDireccion = P003V5_A276SedeDireccion[0] ;
         A185UbigeoNombre = P003V5_A185UbigeoNombre[0] ;
         A116ClinicaNombreComercial = P003V5_A116ClinicaNombreComercial[0] ;
         A75SedeNombre = P003V5_A75SedeNombre[0] ;
         A186UbigeoDepartamento = P003V5_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V5_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V5_A188UbigeoDistrito[0] ;
         A185UbigeoNombre = P003V5_A185UbigeoNombre[0] ;
         A186UbigeoDepartamento = P003V5_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V5_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V5_A188UbigeoDistrito[0] ;
         A118ClinicaRUC = P003V5_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = P003V5_A116ClinicaNombreComercial[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P003V5_A44UbigeoCode[0], A44UbigeoCode) == 0 ) )
         {
            brk3V8 = false ;
            A30SedeId = P003V5_A30SedeId[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A185UbigeoNombre)==0) )
         {
            AV39Option = A185UbigeoNombre ;
            AV38InsertIndex = 1 ;
            while ( ( AV38InsertIndex <= AV40Options.size() ) && ( GXutil.strcmp((String)AV40Options.elementAt(-1+AV38InsertIndex), AV39Option) < 0 ) )
            {
               AV38InsertIndex = (int)(AV38InsertIndex+1) ;
            }
            AV40Options.add(AV39Option, AV38InsertIndex);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), AV38InsertIndex);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V8 )
         {
            brk3V8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADSEDEDIRECCIONOPTIONS' Routine */
      returnInSub = false ;
      AV25TFSedeDireccion = AV35SearchTxt ;
      AV26TFSedeDireccion_Sel = "" ;
      AV58Sedewwds_1_filterfulltext = AV53FilterFullText ;
      AV59Sedewwds_2_tfsedeid = AV11TFSedeId ;
      AV60Sedewwds_3_tfsedeid_to = AV12TFSedeId_To ;
      AV61Sedewwds_4_tfsedenombre = AV13TFSedeNombre ;
      AV62Sedewwds_5_tfsedenombre_sel = AV14TFSedeNombre_Sel ;
      AV63Sedewwds_6_tfclinicaid = AV15TFClinicaId ;
      AV64Sedewwds_7_tfclinicaid_to = AV16TFClinicaId_To ;
      AV65Sedewwds_8_tfclinicaruc = AV17TFClinicaRUC ;
      AV66Sedewwds_9_tfclinicaruc_to = AV18TFClinicaRUC_To ;
      AV67Sedewwds_10_tfclinicanombrecomercial = AV19TFClinicaNombreComercial ;
      AV68Sedewwds_11_tfclinicanombrecomercial_sel = AV20TFClinicaNombreComercial_Sel ;
      AV69Sedewwds_12_tfubigeocode = AV21TFUbigeoCode ;
      AV70Sedewwds_13_tfubigeocode_sel = AV22TFUbigeoCode_Sel ;
      AV71Sedewwds_14_tfubigeonombre = AV23TFUbigeoNombre ;
      AV72Sedewwds_15_tfubigeonombre_sel = AV24TFUbigeoNombre_Sel ;
      AV73Sedewwds_16_tfsededireccion = AV25TFSedeDireccion ;
      AV74Sedewwds_17_tfsededireccion_sel = AV26TFSedeDireccion_Sel ;
      AV75Sedewwds_18_tfsedecorreo = AV27TFSedeCorreo ;
      AV76Sedewwds_19_tfsedecorreo_sel = AV28TFSedeCorreo_Sel ;
      AV77Sedewwds_20_tfsedeestado_sels = AV30TFSedeEstado_Sels ;
      AV78Sedewwds_21_tfsedetipo_sels = AV32TFSedeTipo_Sels ;
      AV79Sedewwds_22_tfsedesector_sels = AV34TFSedeSector_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV77Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV78Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV79Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV59Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV60Sedewwds_3_tfsedeid_to) ,
                                           AV62Sedewwds_5_tfsedenombre_sel ,
                                           AV61Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV63Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV64Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV65Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to) ,
                                           AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV67Sedewwds_10_tfclinicanombrecomercial ,
                                           AV70Sedewwds_13_tfubigeocode_sel ,
                                           AV69Sedewwds_12_tfubigeocode ,
                                           AV72Sedewwds_15_tfubigeonombre_sel ,
                                           AV71Sedewwds_14_tfubigeonombre ,
                                           AV74Sedewwds_17_tfsededireccion_sel ,
                                           AV73Sedewwds_16_tfsededireccion ,
                                           AV76Sedewwds_19_tfsedecorreo_sel ,
                                           AV75Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV77Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV78Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV79Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           AV58Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV61Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV61Sedewwds_4_tfsedenombre), "%", "") ;
      lV67Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV67Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV69Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV69Sedewwds_12_tfubigeocode), 10, "%") ;
      lV71Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV71Sedewwds_14_tfubigeonombre), "%", "") ;
      lV73Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV73Sedewwds_16_tfsededireccion), "%", "") ;
      lV75Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV75Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor P003V6 */
      pr_default.execute(4, new Object[] {AV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, Short.valueOf(AV59Sedewwds_2_tfsedeid), Short.valueOf(AV60Sedewwds_3_tfsedeid_to), lV61Sedewwds_4_tfsedenombre, AV62Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV63Sedewwds_6_tfclinicaid), Short.valueOf(AV64Sedewwds_7_tfclinicaid_to), Long.valueOf(AV65Sedewwds_8_tfclinicaruc), Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to), lV67Sedewwds_10_tfclinicanombrecomercial, AV68Sedewwds_11_tfclinicanombrecomercial_sel, lV69Sedewwds_12_tfubigeocode, AV70Sedewwds_13_tfubigeocode_sel, lV71Sedewwds_14_tfubigeonombre, AV72Sedewwds_15_tfubigeonombre_sel, lV73Sedewwds_16_tfsededireccion, AV74Sedewwds_17_tfsededireccion_sel, lV75Sedewwds_18_tfsedecorreo, AV76Sedewwds_19_tfsedecorreo_sel});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk3V10 = false ;
         A276SedeDireccion = P003V6_A276SedeDireccion[0] ;
         A118ClinicaRUC = P003V6_A118ClinicaRUC[0] ;
         A28ClinicaId = P003V6_A28ClinicaId[0] ;
         A30SedeId = P003V6_A30SedeId[0] ;
         A280SedeSector = P003V6_A280SedeSector[0] ;
         A279SedeTipo = P003V6_A279SedeTipo[0] ;
         A278SedeEstado = P003V6_A278SedeEstado[0] ;
         A277SedeCorreo = P003V6_A277SedeCorreo[0] ;
         A185UbigeoNombre = P003V6_A185UbigeoNombre[0] ;
         A44UbigeoCode = P003V6_A44UbigeoCode[0] ;
         A116ClinicaNombreComercial = P003V6_A116ClinicaNombreComercial[0] ;
         A75SedeNombre = P003V6_A75SedeNombre[0] ;
         A186UbigeoDepartamento = P003V6_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V6_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V6_A188UbigeoDistrito[0] ;
         A118ClinicaRUC = P003V6_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = P003V6_A116ClinicaNombreComercial[0] ;
         A185UbigeoNombre = P003V6_A185UbigeoNombre[0] ;
         A186UbigeoDepartamento = P003V6_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V6_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V6_A188UbigeoDistrito[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P003V6_A276SedeDireccion[0], A276SedeDireccion) == 0 ) )
         {
            brk3V10 = false ;
            A30SedeId = P003V6_A30SedeId[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A276SedeDireccion)==0) )
         {
            AV39Option = A276SedeDireccion ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V10 )
         {
            brk3V10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADSEDECORREOOPTIONS' Routine */
      returnInSub = false ;
      AV27TFSedeCorreo = AV35SearchTxt ;
      AV28TFSedeCorreo_Sel = "" ;
      AV58Sedewwds_1_filterfulltext = AV53FilterFullText ;
      AV59Sedewwds_2_tfsedeid = AV11TFSedeId ;
      AV60Sedewwds_3_tfsedeid_to = AV12TFSedeId_To ;
      AV61Sedewwds_4_tfsedenombre = AV13TFSedeNombre ;
      AV62Sedewwds_5_tfsedenombre_sel = AV14TFSedeNombre_Sel ;
      AV63Sedewwds_6_tfclinicaid = AV15TFClinicaId ;
      AV64Sedewwds_7_tfclinicaid_to = AV16TFClinicaId_To ;
      AV65Sedewwds_8_tfclinicaruc = AV17TFClinicaRUC ;
      AV66Sedewwds_9_tfclinicaruc_to = AV18TFClinicaRUC_To ;
      AV67Sedewwds_10_tfclinicanombrecomercial = AV19TFClinicaNombreComercial ;
      AV68Sedewwds_11_tfclinicanombrecomercial_sel = AV20TFClinicaNombreComercial_Sel ;
      AV69Sedewwds_12_tfubigeocode = AV21TFUbigeoCode ;
      AV70Sedewwds_13_tfubigeocode_sel = AV22TFUbigeoCode_Sel ;
      AV71Sedewwds_14_tfubigeonombre = AV23TFUbigeoNombre ;
      AV72Sedewwds_15_tfubigeonombre_sel = AV24TFUbigeoNombre_Sel ;
      AV73Sedewwds_16_tfsededireccion = AV25TFSedeDireccion ;
      AV74Sedewwds_17_tfsededireccion_sel = AV26TFSedeDireccion_Sel ;
      AV75Sedewwds_18_tfsedecorreo = AV27TFSedeCorreo ;
      AV76Sedewwds_19_tfsedecorreo_sel = AV28TFSedeCorreo_Sel ;
      AV77Sedewwds_20_tfsedeestado_sels = AV30TFSedeEstado_Sels ;
      AV78Sedewwds_21_tfsedetipo_sels = AV32TFSedeTipo_Sels ;
      AV79Sedewwds_22_tfsedesector_sels = AV34TFSedeSector_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV77Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV78Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV79Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV59Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV60Sedewwds_3_tfsedeid_to) ,
                                           AV62Sedewwds_5_tfsedenombre_sel ,
                                           AV61Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV63Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV64Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV65Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to) ,
                                           AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV67Sedewwds_10_tfclinicanombrecomercial ,
                                           AV70Sedewwds_13_tfubigeocode_sel ,
                                           AV69Sedewwds_12_tfubigeocode ,
                                           AV72Sedewwds_15_tfubigeonombre_sel ,
                                           AV71Sedewwds_14_tfubigeonombre ,
                                           AV74Sedewwds_17_tfsededireccion_sel ,
                                           AV73Sedewwds_16_tfsededireccion ,
                                           AV76Sedewwds_19_tfsedecorreo_sel ,
                                           AV75Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV77Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV78Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV79Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           AV58Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV58Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Sedewwds_1_filterfulltext), "%", "") ;
      lV61Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV61Sedewwds_4_tfsedenombre), "%", "") ;
      lV67Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV67Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV69Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV69Sedewwds_12_tfubigeocode), 10, "%") ;
      lV71Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV71Sedewwds_14_tfubigeonombre), "%", "") ;
      lV73Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV73Sedewwds_16_tfsededireccion), "%", "") ;
      lV75Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV75Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor P003V7 */
      pr_default.execute(5, new Object[] {AV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, lV58Sedewwds_1_filterfulltext, Short.valueOf(AV59Sedewwds_2_tfsedeid), Short.valueOf(AV60Sedewwds_3_tfsedeid_to), lV61Sedewwds_4_tfsedenombre, AV62Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV63Sedewwds_6_tfclinicaid), Short.valueOf(AV64Sedewwds_7_tfclinicaid_to), Long.valueOf(AV65Sedewwds_8_tfclinicaruc), Long.valueOf(AV66Sedewwds_9_tfclinicaruc_to), lV67Sedewwds_10_tfclinicanombrecomercial, AV68Sedewwds_11_tfclinicanombrecomercial_sel, lV69Sedewwds_12_tfubigeocode, AV70Sedewwds_13_tfubigeocode_sel, lV71Sedewwds_14_tfubigeonombre, AV72Sedewwds_15_tfubigeonombre_sel, lV73Sedewwds_16_tfsededireccion, AV74Sedewwds_17_tfsededireccion_sel, lV75Sedewwds_18_tfsedecorreo, AV76Sedewwds_19_tfsedecorreo_sel});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk3V12 = false ;
         A277SedeCorreo = P003V7_A277SedeCorreo[0] ;
         A118ClinicaRUC = P003V7_A118ClinicaRUC[0] ;
         A28ClinicaId = P003V7_A28ClinicaId[0] ;
         A30SedeId = P003V7_A30SedeId[0] ;
         A280SedeSector = P003V7_A280SedeSector[0] ;
         A279SedeTipo = P003V7_A279SedeTipo[0] ;
         A278SedeEstado = P003V7_A278SedeEstado[0] ;
         A276SedeDireccion = P003V7_A276SedeDireccion[0] ;
         A185UbigeoNombre = P003V7_A185UbigeoNombre[0] ;
         A44UbigeoCode = P003V7_A44UbigeoCode[0] ;
         A116ClinicaNombreComercial = P003V7_A116ClinicaNombreComercial[0] ;
         A75SedeNombre = P003V7_A75SedeNombre[0] ;
         A186UbigeoDepartamento = P003V7_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V7_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V7_A188UbigeoDistrito[0] ;
         A118ClinicaRUC = P003V7_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = P003V7_A116ClinicaNombreComercial[0] ;
         A185UbigeoNombre = P003V7_A185UbigeoNombre[0] ;
         A186UbigeoDepartamento = P003V7_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P003V7_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P003V7_A188UbigeoDistrito[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P003V7_A277SedeCorreo[0], A277SedeCorreo) == 0 ) )
         {
            brk3V12 = false ;
            A30SedeId = P003V7_A30SedeId[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A277SedeCorreo)==0) )
         {
            AV39Option = A277SedeCorreo ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V12 )
         {
            brk3V12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   protected void cleanup( )
   {
      this.aP3[0] = sedewwgetfilterdata.this.AV41OptionsJson;
      this.aP4[0] = sedewwgetfilterdata.this.AV44OptionsDescJson;
      this.aP5[0] = sedewwgetfilterdata.this.AV46OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV41OptionsJson = "" ;
      AV44OptionsDescJson = "" ;
      AV46OptionIndexesJson = "" ;
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV48Session = httpContext.getWebSession();
      AV50GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV51GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV53FilterFullText = "" ;
      AV13TFSedeNombre = "" ;
      AV14TFSedeNombre_Sel = "" ;
      AV19TFClinicaNombreComercial = "" ;
      AV20TFClinicaNombreComercial_Sel = "" ;
      AV21TFUbigeoCode = "" ;
      AV22TFUbigeoCode_Sel = "" ;
      AV23TFUbigeoNombre = "" ;
      AV24TFUbigeoNombre_Sel = "" ;
      AV25TFSedeDireccion = "" ;
      AV26TFSedeDireccion_Sel = "" ;
      AV27TFSedeCorreo = "" ;
      AV28TFSedeCorreo_Sel = "" ;
      AV29TFSedeEstado_SelsJson = "" ;
      AV30TFSedeEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFSedeTipo_SelsJson = "" ;
      AV32TFSedeTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33TFSedeSector_SelsJson = "" ;
      AV34TFSedeSector_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A75SedeNombre = "" ;
      AV58Sedewwds_1_filterfulltext = "" ;
      AV61Sedewwds_4_tfsedenombre = "" ;
      AV62Sedewwds_5_tfsedenombre_sel = "" ;
      AV67Sedewwds_10_tfclinicanombrecomercial = "" ;
      AV68Sedewwds_11_tfclinicanombrecomercial_sel = "" ;
      AV69Sedewwds_12_tfubigeocode = "" ;
      AV70Sedewwds_13_tfubigeocode_sel = "" ;
      AV71Sedewwds_14_tfubigeonombre = "" ;
      AV72Sedewwds_15_tfubigeonombre_sel = "" ;
      AV73Sedewwds_16_tfsededireccion = "" ;
      AV74Sedewwds_17_tfsededireccion_sel = "" ;
      AV75Sedewwds_18_tfsedecorreo = "" ;
      AV76Sedewwds_19_tfsedecorreo_sel = "" ;
      AV77Sedewwds_20_tfsedeestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78Sedewwds_21_tfsedetipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Sedewwds_22_tfsedesector_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV58Sedewwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV61Sedewwds_4_tfsedenombre = "" ;
      lV67Sedewwds_10_tfclinicanombrecomercial = "" ;
      lV69Sedewwds_12_tfubigeocode = "" ;
      lV71Sedewwds_14_tfubigeonombre = "" ;
      lV73Sedewwds_16_tfsededireccion = "" ;
      lV75Sedewwds_18_tfsedecorreo = "" ;
      A278SedeEstado = "" ;
      A279SedeTipo = "" ;
      A280SedeSector = "" ;
      A116ClinicaNombreComercial = "" ;
      A44UbigeoCode = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      A276SedeDireccion = "" ;
      A277SedeCorreo = "" ;
      A185UbigeoNombre = "" ;
      P003V2_A75SedeNombre = new String[] {""} ;
      P003V2_A118ClinicaRUC = new long[1] ;
      P003V2_A28ClinicaId = new short[1] ;
      P003V2_A30SedeId = new short[1] ;
      P003V2_A280SedeSector = new String[] {""} ;
      P003V2_A279SedeTipo = new String[] {""} ;
      P003V2_A278SedeEstado = new String[] {""} ;
      P003V2_A277SedeCorreo = new String[] {""} ;
      P003V2_A276SedeDireccion = new String[] {""} ;
      P003V2_A185UbigeoNombre = new String[] {""} ;
      P003V2_A44UbigeoCode = new String[] {""} ;
      P003V2_A116ClinicaNombreComercial = new String[] {""} ;
      P003V2_A186UbigeoDepartamento = new String[] {""} ;
      P003V2_A187UbigeoProvincia = new String[] {""} ;
      P003V2_A188UbigeoDistrito = new String[] {""} ;
      AV39Option = "" ;
      P003V3_A116ClinicaNombreComercial = new String[] {""} ;
      P003V3_A118ClinicaRUC = new long[1] ;
      P003V3_A28ClinicaId = new short[1] ;
      P003V3_A30SedeId = new short[1] ;
      P003V3_A280SedeSector = new String[] {""} ;
      P003V3_A279SedeTipo = new String[] {""} ;
      P003V3_A278SedeEstado = new String[] {""} ;
      P003V3_A277SedeCorreo = new String[] {""} ;
      P003V3_A276SedeDireccion = new String[] {""} ;
      P003V3_A185UbigeoNombre = new String[] {""} ;
      P003V3_A44UbigeoCode = new String[] {""} ;
      P003V3_A75SedeNombre = new String[] {""} ;
      P003V3_A186UbigeoDepartamento = new String[] {""} ;
      P003V3_A187UbigeoProvincia = new String[] {""} ;
      P003V3_A188UbigeoDistrito = new String[] {""} ;
      P003V4_A44UbigeoCode = new String[] {""} ;
      P003V4_A118ClinicaRUC = new long[1] ;
      P003V4_A28ClinicaId = new short[1] ;
      P003V4_A30SedeId = new short[1] ;
      P003V4_A280SedeSector = new String[] {""} ;
      P003V4_A279SedeTipo = new String[] {""} ;
      P003V4_A278SedeEstado = new String[] {""} ;
      P003V4_A277SedeCorreo = new String[] {""} ;
      P003V4_A276SedeDireccion = new String[] {""} ;
      P003V4_A185UbigeoNombre = new String[] {""} ;
      P003V4_A116ClinicaNombreComercial = new String[] {""} ;
      P003V4_A75SedeNombre = new String[] {""} ;
      P003V4_A186UbigeoDepartamento = new String[] {""} ;
      P003V4_A187UbigeoProvincia = new String[] {""} ;
      P003V4_A188UbigeoDistrito = new String[] {""} ;
      P003V5_A44UbigeoCode = new String[] {""} ;
      P003V5_A118ClinicaRUC = new long[1] ;
      P003V5_A28ClinicaId = new short[1] ;
      P003V5_A30SedeId = new short[1] ;
      P003V5_A280SedeSector = new String[] {""} ;
      P003V5_A279SedeTipo = new String[] {""} ;
      P003V5_A278SedeEstado = new String[] {""} ;
      P003V5_A277SedeCorreo = new String[] {""} ;
      P003V5_A276SedeDireccion = new String[] {""} ;
      P003V5_A185UbigeoNombre = new String[] {""} ;
      P003V5_A116ClinicaNombreComercial = new String[] {""} ;
      P003V5_A75SedeNombre = new String[] {""} ;
      P003V5_A186UbigeoDepartamento = new String[] {""} ;
      P003V5_A187UbigeoProvincia = new String[] {""} ;
      P003V5_A188UbigeoDistrito = new String[] {""} ;
      P003V6_A276SedeDireccion = new String[] {""} ;
      P003V6_A118ClinicaRUC = new long[1] ;
      P003V6_A28ClinicaId = new short[1] ;
      P003V6_A30SedeId = new short[1] ;
      P003V6_A280SedeSector = new String[] {""} ;
      P003V6_A279SedeTipo = new String[] {""} ;
      P003V6_A278SedeEstado = new String[] {""} ;
      P003V6_A277SedeCorreo = new String[] {""} ;
      P003V6_A185UbigeoNombre = new String[] {""} ;
      P003V6_A44UbigeoCode = new String[] {""} ;
      P003V6_A116ClinicaNombreComercial = new String[] {""} ;
      P003V6_A75SedeNombre = new String[] {""} ;
      P003V6_A186UbigeoDepartamento = new String[] {""} ;
      P003V6_A187UbigeoProvincia = new String[] {""} ;
      P003V6_A188UbigeoDistrito = new String[] {""} ;
      P003V7_A277SedeCorreo = new String[] {""} ;
      P003V7_A118ClinicaRUC = new long[1] ;
      P003V7_A28ClinicaId = new short[1] ;
      P003V7_A30SedeId = new short[1] ;
      P003V7_A280SedeSector = new String[] {""} ;
      P003V7_A279SedeTipo = new String[] {""} ;
      P003V7_A278SedeEstado = new String[] {""} ;
      P003V7_A276SedeDireccion = new String[] {""} ;
      P003V7_A185UbigeoNombre = new String[] {""} ;
      P003V7_A44UbigeoCode = new String[] {""} ;
      P003V7_A116ClinicaNombreComercial = new String[] {""} ;
      P003V7_A75SedeNombre = new String[] {""} ;
      P003V7_A186UbigeoDepartamento = new String[] {""} ;
      P003V7_A187UbigeoProvincia = new String[] {""} ;
      P003V7_A188UbigeoDistrito = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sedewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003V2_A75SedeNombre, P003V2_A118ClinicaRUC, P003V2_A28ClinicaId, P003V2_A30SedeId, P003V2_A280SedeSector, P003V2_A279SedeTipo, P003V2_A278SedeEstado, P003V2_A277SedeCorreo, P003V2_A276SedeDireccion, P003V2_A185UbigeoNombre,
            P003V2_A44UbigeoCode, P003V2_A116ClinicaNombreComercial, P003V2_A186UbigeoDepartamento, P003V2_A187UbigeoProvincia, P003V2_A188UbigeoDistrito
            }
            , new Object[] {
            P003V3_A116ClinicaNombreComercial, P003V3_A118ClinicaRUC, P003V3_A28ClinicaId, P003V3_A30SedeId, P003V3_A280SedeSector, P003V3_A279SedeTipo, P003V3_A278SedeEstado, P003V3_A277SedeCorreo, P003V3_A276SedeDireccion, P003V3_A185UbigeoNombre,
            P003V3_A44UbigeoCode, P003V3_A75SedeNombre, P003V3_A186UbigeoDepartamento, P003V3_A187UbigeoProvincia, P003V3_A188UbigeoDistrito
            }
            , new Object[] {
            P003V4_A44UbigeoCode, P003V4_A118ClinicaRUC, P003V4_A28ClinicaId, P003V4_A30SedeId, P003V4_A280SedeSector, P003V4_A279SedeTipo, P003V4_A278SedeEstado, P003V4_A277SedeCorreo, P003V4_A276SedeDireccion, P003V4_A185UbigeoNombre,
            P003V4_A116ClinicaNombreComercial, P003V4_A75SedeNombre, P003V4_A186UbigeoDepartamento, P003V4_A187UbigeoProvincia, P003V4_A188UbigeoDistrito
            }
            , new Object[] {
            P003V5_A44UbigeoCode, P003V5_A118ClinicaRUC, P003V5_A28ClinicaId, P003V5_A30SedeId, P003V5_A280SedeSector, P003V5_A279SedeTipo, P003V5_A278SedeEstado, P003V5_A277SedeCorreo, P003V5_A276SedeDireccion, P003V5_A185UbigeoNombre,
            P003V5_A116ClinicaNombreComercial, P003V5_A75SedeNombre, P003V5_A186UbigeoDepartamento, P003V5_A187UbigeoProvincia, P003V5_A188UbigeoDistrito
            }
            , new Object[] {
            P003V6_A276SedeDireccion, P003V6_A118ClinicaRUC, P003V6_A28ClinicaId, P003V6_A30SedeId, P003V6_A280SedeSector, P003V6_A279SedeTipo, P003V6_A278SedeEstado, P003V6_A277SedeCorreo, P003V6_A185UbigeoNombre, P003V6_A44UbigeoCode,
            P003V6_A116ClinicaNombreComercial, P003V6_A75SedeNombre, P003V6_A186UbigeoDepartamento, P003V6_A187UbigeoProvincia, P003V6_A188UbigeoDistrito
            }
            , new Object[] {
            P003V7_A277SedeCorreo, P003V7_A118ClinicaRUC, P003V7_A28ClinicaId, P003V7_A30SedeId, P003V7_A280SedeSector, P003V7_A279SedeTipo, P003V7_A278SedeEstado, P003V7_A276SedeDireccion, P003V7_A185UbigeoNombre, P003V7_A44UbigeoCode,
            P003V7_A116ClinicaNombreComercial, P003V7_A75SedeNombre, P003V7_A186UbigeoDepartamento, P003V7_A187UbigeoProvincia, P003V7_A188UbigeoDistrito
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFSedeId ;
   private short AV12TFSedeId_To ;
   private short AV15TFClinicaId ;
   private short AV16TFClinicaId_To ;
   private short AV59Sedewwds_2_tfsedeid ;
   private short AV60Sedewwds_3_tfsedeid_to ;
   private short AV63Sedewwds_6_tfclinicaid ;
   private short AV64Sedewwds_7_tfclinicaid_to ;
   private short A30SedeId ;
   private short A28ClinicaId ;
   private short Gx_err ;
   private int AV56GXV1 ;
   private int AV77Sedewwds_20_tfsedeestado_sels_size ;
   private int AV78Sedewwds_21_tfsedetipo_sels_size ;
   private int AV79Sedewwds_22_tfsedesector_sels_size ;
   private int AV38InsertIndex ;
   private long AV17TFClinicaRUC ;
   private long AV18TFClinicaRUC_To ;
   private long AV65Sedewwds_8_tfclinicaruc ;
   private long AV66Sedewwds_9_tfclinicaruc_to ;
   private long A118ClinicaRUC ;
   private long AV47count ;
   private String AV21TFUbigeoCode ;
   private String AV22TFUbigeoCode_Sel ;
   private String AV69Sedewwds_12_tfubigeocode ;
   private String AV70Sedewwds_13_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV69Sedewwds_12_tfubigeocode ;
   private String A278SedeEstado ;
   private String A279SedeTipo ;
   private String A280SedeSector ;
   private String A44UbigeoCode ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3V2 ;
   private boolean brk3V4 ;
   private boolean brk3V6 ;
   private boolean brk3V8 ;
   private boolean brk3V10 ;
   private boolean brk3V12 ;
   private String AV41OptionsJson ;
   private String AV44OptionsDescJson ;
   private String AV46OptionIndexesJson ;
   private String AV29TFSedeEstado_SelsJson ;
   private String AV31TFSedeTipo_SelsJson ;
   private String AV33TFSedeSector_SelsJson ;
   private String AV37DDOName ;
   private String AV35SearchTxt ;
   private String AV36SearchTxtTo ;
   private String AV53FilterFullText ;
   private String AV13TFSedeNombre ;
   private String AV14TFSedeNombre_Sel ;
   private String AV19TFClinicaNombreComercial ;
   private String AV20TFClinicaNombreComercial_Sel ;
   private String AV23TFUbigeoNombre ;
   private String AV24TFUbigeoNombre_Sel ;
   private String AV25TFSedeDireccion ;
   private String AV26TFSedeDireccion_Sel ;
   private String AV27TFSedeCorreo ;
   private String AV28TFSedeCorreo_Sel ;
   private String A75SedeNombre ;
   private String AV58Sedewwds_1_filterfulltext ;
   private String AV61Sedewwds_4_tfsedenombre ;
   private String AV62Sedewwds_5_tfsedenombre_sel ;
   private String AV67Sedewwds_10_tfclinicanombrecomercial ;
   private String AV68Sedewwds_11_tfclinicanombrecomercial_sel ;
   private String AV71Sedewwds_14_tfubigeonombre ;
   private String AV72Sedewwds_15_tfubigeonombre_sel ;
   private String AV73Sedewwds_16_tfsededireccion ;
   private String AV74Sedewwds_17_tfsededireccion_sel ;
   private String AV75Sedewwds_18_tfsedecorreo ;
   private String AV76Sedewwds_19_tfsedecorreo_sel ;
   private String lV58Sedewwds_1_filterfulltext ;
   private String lV61Sedewwds_4_tfsedenombre ;
   private String lV67Sedewwds_10_tfclinicanombrecomercial ;
   private String lV71Sedewwds_14_tfubigeonombre ;
   private String lV73Sedewwds_16_tfsededireccion ;
   private String lV75Sedewwds_18_tfsedecorreo ;
   private String A116ClinicaNombreComercial ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A276SedeDireccion ;
   private String A277SedeCorreo ;
   private String A185UbigeoNombre ;
   private String AV39Option ;
   private com.genexus.webpanels.WebSession AV48Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P003V2_A75SedeNombre ;
   private long[] P003V2_A118ClinicaRUC ;
   private short[] P003V2_A28ClinicaId ;
   private short[] P003V2_A30SedeId ;
   private String[] P003V2_A280SedeSector ;
   private String[] P003V2_A279SedeTipo ;
   private String[] P003V2_A278SedeEstado ;
   private String[] P003V2_A277SedeCorreo ;
   private String[] P003V2_A276SedeDireccion ;
   private String[] P003V2_A185UbigeoNombre ;
   private String[] P003V2_A44UbigeoCode ;
   private String[] P003V2_A116ClinicaNombreComercial ;
   private String[] P003V2_A186UbigeoDepartamento ;
   private String[] P003V2_A187UbigeoProvincia ;
   private String[] P003V2_A188UbigeoDistrito ;
   private String[] P003V3_A116ClinicaNombreComercial ;
   private long[] P003V3_A118ClinicaRUC ;
   private short[] P003V3_A28ClinicaId ;
   private short[] P003V3_A30SedeId ;
   private String[] P003V3_A280SedeSector ;
   private String[] P003V3_A279SedeTipo ;
   private String[] P003V3_A278SedeEstado ;
   private String[] P003V3_A277SedeCorreo ;
   private String[] P003V3_A276SedeDireccion ;
   private String[] P003V3_A185UbigeoNombre ;
   private String[] P003V3_A44UbigeoCode ;
   private String[] P003V3_A75SedeNombre ;
   private String[] P003V3_A186UbigeoDepartamento ;
   private String[] P003V3_A187UbigeoProvincia ;
   private String[] P003V3_A188UbigeoDistrito ;
   private String[] P003V4_A44UbigeoCode ;
   private long[] P003V4_A118ClinicaRUC ;
   private short[] P003V4_A28ClinicaId ;
   private short[] P003V4_A30SedeId ;
   private String[] P003V4_A280SedeSector ;
   private String[] P003V4_A279SedeTipo ;
   private String[] P003V4_A278SedeEstado ;
   private String[] P003V4_A277SedeCorreo ;
   private String[] P003V4_A276SedeDireccion ;
   private String[] P003V4_A185UbigeoNombre ;
   private String[] P003V4_A116ClinicaNombreComercial ;
   private String[] P003V4_A75SedeNombre ;
   private String[] P003V4_A186UbigeoDepartamento ;
   private String[] P003V4_A187UbigeoProvincia ;
   private String[] P003V4_A188UbigeoDistrito ;
   private String[] P003V5_A44UbigeoCode ;
   private long[] P003V5_A118ClinicaRUC ;
   private short[] P003V5_A28ClinicaId ;
   private short[] P003V5_A30SedeId ;
   private String[] P003V5_A280SedeSector ;
   private String[] P003V5_A279SedeTipo ;
   private String[] P003V5_A278SedeEstado ;
   private String[] P003V5_A277SedeCorreo ;
   private String[] P003V5_A276SedeDireccion ;
   private String[] P003V5_A185UbigeoNombre ;
   private String[] P003V5_A116ClinicaNombreComercial ;
   private String[] P003V5_A75SedeNombre ;
   private String[] P003V5_A186UbigeoDepartamento ;
   private String[] P003V5_A187UbigeoProvincia ;
   private String[] P003V5_A188UbigeoDistrito ;
   private String[] P003V6_A276SedeDireccion ;
   private long[] P003V6_A118ClinicaRUC ;
   private short[] P003V6_A28ClinicaId ;
   private short[] P003V6_A30SedeId ;
   private String[] P003V6_A280SedeSector ;
   private String[] P003V6_A279SedeTipo ;
   private String[] P003V6_A278SedeEstado ;
   private String[] P003V6_A277SedeCorreo ;
   private String[] P003V6_A185UbigeoNombre ;
   private String[] P003V6_A44UbigeoCode ;
   private String[] P003V6_A116ClinicaNombreComercial ;
   private String[] P003V6_A75SedeNombre ;
   private String[] P003V6_A186UbigeoDepartamento ;
   private String[] P003V6_A187UbigeoProvincia ;
   private String[] P003V6_A188UbigeoDistrito ;
   private String[] P003V7_A277SedeCorreo ;
   private long[] P003V7_A118ClinicaRUC ;
   private short[] P003V7_A28ClinicaId ;
   private short[] P003V7_A30SedeId ;
   private String[] P003V7_A280SedeSector ;
   private String[] P003V7_A279SedeTipo ;
   private String[] P003V7_A278SedeEstado ;
   private String[] P003V7_A276SedeDireccion ;
   private String[] P003V7_A185UbigeoNombre ;
   private String[] P003V7_A44UbigeoCode ;
   private String[] P003V7_A116ClinicaNombreComercial ;
   private String[] P003V7_A75SedeNombre ;
   private String[] P003V7_A186UbigeoDepartamento ;
   private String[] P003V7_A187UbigeoProvincia ;
   private String[] P003V7_A188UbigeoDistrito ;
   private GXSimpleCollection<String> AV30TFSedeEstado_Sels ;
   private GXSimpleCollection<String> AV32TFSedeTipo_Sels ;
   private GXSimpleCollection<String> AV34TFSedeSector_Sels ;
   private GXSimpleCollection<String> AV77Sedewwds_20_tfsedeestado_sels ;
   private GXSimpleCollection<String> AV78Sedewwds_21_tfsedetipo_sels ;
   private GXSimpleCollection<String> AV79Sedewwds_22_tfsedesector_sels ;
   private GXSimpleCollection<String> AV40Options ;
   private GXSimpleCollection<String> AV43OptionsDesc ;
   private GXSimpleCollection<String> AV45OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV50GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV51GridStateFilterValue ;
}

final  class sedewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV77Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV78Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV79Sedewwds_22_tfsedesector_sels ,
                                          short AV59Sedewwds_2_tfsedeid ,
                                          short AV60Sedewwds_3_tfsedeid_to ,
                                          String AV62Sedewwds_5_tfsedenombre_sel ,
                                          String AV61Sedewwds_4_tfsedenombre ,
                                          short AV63Sedewwds_6_tfclinicaid ,
                                          short AV64Sedewwds_7_tfclinicaid_to ,
                                          long AV65Sedewwds_8_tfclinicaruc ,
                                          long AV66Sedewwds_9_tfclinicaruc_to ,
                                          String AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV67Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV70Sedewwds_13_tfubigeocode_sel ,
                                          String AV69Sedewwds_12_tfubigeocode ,
                                          String AV72Sedewwds_15_tfubigeonombre_sel ,
                                          String AV71Sedewwds_14_tfubigeonombre ,
                                          String AV74Sedewwds_17_tfsededireccion_sel ,
                                          String AV73Sedewwds_16_tfsededireccion ,
                                          String AV76Sedewwds_19_tfsedecorreo_sel ,
                                          String AV75Sedewwds_18_tfsedecorreo ,
                                          int AV77Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV78Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV79Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          String AV58Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[38];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[SedeNombre], T2.[ClinicaRUC], T1.[ClinicaId], T1.[SedeId], T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeCorreo], T1.[SedeDireccion], T3.[UbigeoDepartamento]" ;
      scmdbuf += " + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] AS UbigeoNombre, T1.[UbigeoCode], T2.[ClinicaNombreComercial], T3.[UbigeoDepartamento], T3.[UbigeoProvincia]," ;
      scmdbuf += " T3.[UbigeoDistrito] FROM (([Sede] T1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = T1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T2.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T2.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV59Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (0==AV60Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV61Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (0==AV63Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV64Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (0==AV65Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( ! (0==AV66Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV67Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV69Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV71Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV73Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( AV77Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV78Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV78Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV79Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV79Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SedeNombre]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003V3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV77Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV78Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV79Sedewwds_22_tfsedesector_sels ,
                                          short AV59Sedewwds_2_tfsedeid ,
                                          short AV60Sedewwds_3_tfsedeid_to ,
                                          String AV62Sedewwds_5_tfsedenombre_sel ,
                                          String AV61Sedewwds_4_tfsedenombre ,
                                          short AV63Sedewwds_6_tfclinicaid ,
                                          short AV64Sedewwds_7_tfclinicaid_to ,
                                          long AV65Sedewwds_8_tfclinicaruc ,
                                          long AV66Sedewwds_9_tfclinicaruc_to ,
                                          String AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV67Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV70Sedewwds_13_tfubigeocode_sel ,
                                          String AV69Sedewwds_12_tfubigeocode ,
                                          String AV72Sedewwds_15_tfubigeonombre_sel ,
                                          String AV71Sedewwds_14_tfubigeonombre ,
                                          String AV74Sedewwds_17_tfsededireccion_sel ,
                                          String AV73Sedewwds_16_tfsededireccion ,
                                          String AV76Sedewwds_19_tfsedecorreo_sel ,
                                          String AV75Sedewwds_18_tfsedecorreo ,
                                          int AV77Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV78Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV79Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          String AV58Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[38];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T2.[ClinicaNombreComercial], T2.[ClinicaRUC], T1.[ClinicaId], T1.[SedeId], T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeCorreo], T1.[SedeDireccion]," ;
      scmdbuf += " T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] AS UbigeoNombre, T1.[UbigeoCode], T1.[SedeNombre], T3.[UbigeoDepartamento]," ;
      scmdbuf += " T3.[UbigeoProvincia], T3.[UbigeoDistrito] FROM (([Sede] T1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = T1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode]" ;
      scmdbuf += " = T1.[UbigeoCode])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T2.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T2.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV59Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int7[20] = (byte)(1) ;
      }
      if ( ! (0==AV60Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int7[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV61Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int7[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int7[23] = (byte)(1) ;
      }
      if ( ! (0==AV63Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int7[24] = (byte)(1) ;
      }
      if ( ! (0==AV64Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int7[25] = (byte)(1) ;
      }
      if ( ! (0==AV65Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int7[26] = (byte)(1) ;
      }
      if ( ! (0==AV66Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int7[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV67Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int7[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int7[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV69Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int7[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int7[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV71Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int7[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int7[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV73Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int7[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int7[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int7[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int7[37] = (byte)(1) ;
      }
      if ( AV77Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV78Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV78Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV79Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV79Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[ClinicaNombreComercial]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P003V4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV77Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV78Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV79Sedewwds_22_tfsedesector_sels ,
                                          short AV59Sedewwds_2_tfsedeid ,
                                          short AV60Sedewwds_3_tfsedeid_to ,
                                          String AV62Sedewwds_5_tfsedenombre_sel ,
                                          String AV61Sedewwds_4_tfsedenombre ,
                                          short AV63Sedewwds_6_tfclinicaid ,
                                          short AV64Sedewwds_7_tfclinicaid_to ,
                                          long AV65Sedewwds_8_tfclinicaruc ,
                                          long AV66Sedewwds_9_tfclinicaruc_to ,
                                          String AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV67Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV70Sedewwds_13_tfubigeocode_sel ,
                                          String AV69Sedewwds_12_tfubigeocode ,
                                          String AV72Sedewwds_15_tfubigeonombre_sel ,
                                          String AV71Sedewwds_14_tfubigeonombre ,
                                          String AV74Sedewwds_17_tfsededireccion_sel ,
                                          String AV73Sedewwds_16_tfsededireccion ,
                                          String AV76Sedewwds_19_tfsedecorreo_sel ,
                                          String AV75Sedewwds_18_tfsedecorreo ,
                                          int AV77Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV78Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV79Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          String AV58Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[38];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[UbigeoCode], T3.[ClinicaRUC], T1.[ClinicaId], T1.[SedeId], T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeCorreo], T1.[SedeDireccion], T2.[UbigeoDepartamento]" ;
      scmdbuf += " + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] AS UbigeoNombre, T3.[ClinicaNombreComercial], T1.[SedeNombre], T2.[UbigeoDepartamento], T2.[UbigeoProvincia]," ;
      scmdbuf += " T2.[UbigeoDistrito] FROM (([Sede] T1 INNER JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T1.[ClinicaId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T3.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T3.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV59Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV60Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV61Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (0==AV63Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV64Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (0==AV65Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T3.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( ! (0==AV66Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T3.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV67Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV69Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int10[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int10[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV71Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int10[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int10[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV73Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int10[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int10[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int10[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int10[37] = (byte)(1) ;
      }
      if ( AV77Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV78Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV78Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV79Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV79Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P003V5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV77Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV78Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV79Sedewwds_22_tfsedesector_sels ,
                                          short AV59Sedewwds_2_tfsedeid ,
                                          short AV60Sedewwds_3_tfsedeid_to ,
                                          String AV62Sedewwds_5_tfsedenombre_sel ,
                                          String AV61Sedewwds_4_tfsedenombre ,
                                          short AV63Sedewwds_6_tfclinicaid ,
                                          short AV64Sedewwds_7_tfclinicaid_to ,
                                          long AV65Sedewwds_8_tfclinicaruc ,
                                          long AV66Sedewwds_9_tfclinicaruc_to ,
                                          String AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV67Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV70Sedewwds_13_tfubigeocode_sel ,
                                          String AV69Sedewwds_12_tfubigeocode ,
                                          String AV72Sedewwds_15_tfubigeonombre_sel ,
                                          String AV71Sedewwds_14_tfubigeonombre ,
                                          String AV74Sedewwds_17_tfsededireccion_sel ,
                                          String AV73Sedewwds_16_tfsededireccion ,
                                          String AV76Sedewwds_19_tfsedecorreo_sel ,
                                          String AV75Sedewwds_18_tfsedecorreo ,
                                          int AV77Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV78Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV79Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          String AV58Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[38];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT T1.[UbigeoCode], T3.[ClinicaRUC], T1.[ClinicaId], T1.[SedeId], T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeCorreo], T1.[SedeDireccion], T2.[UbigeoDepartamento]" ;
      scmdbuf += " + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] AS UbigeoNombre, T3.[ClinicaNombreComercial], T1.[SedeNombre], T2.[UbigeoDepartamento], T2.[UbigeoProvincia]," ;
      scmdbuf += " T2.[UbigeoDistrito] FROM (([Sede] T1 INNER JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T1.[ClinicaId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T3.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T3.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV59Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int13[20] = (byte)(1) ;
      }
      if ( ! (0==AV60Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int13[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV61Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int13[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int13[23] = (byte)(1) ;
      }
      if ( ! (0==AV63Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int13[24] = (byte)(1) ;
      }
      if ( ! (0==AV64Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int13[25] = (byte)(1) ;
      }
      if ( ! (0==AV65Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T3.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int13[26] = (byte)(1) ;
      }
      if ( ! (0==AV66Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T3.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int13[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV67Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int13[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int13[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV69Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int13[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int13[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV71Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int13[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int13[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV73Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int13[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int13[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int13[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int13[37] = (byte)(1) ;
      }
      if ( AV77Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV78Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV78Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV79Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV79Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P003V6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV77Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV78Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV79Sedewwds_22_tfsedesector_sels ,
                                          short AV59Sedewwds_2_tfsedeid ,
                                          short AV60Sedewwds_3_tfsedeid_to ,
                                          String AV62Sedewwds_5_tfsedenombre_sel ,
                                          String AV61Sedewwds_4_tfsedenombre ,
                                          short AV63Sedewwds_6_tfclinicaid ,
                                          short AV64Sedewwds_7_tfclinicaid_to ,
                                          long AV65Sedewwds_8_tfclinicaruc ,
                                          long AV66Sedewwds_9_tfclinicaruc_to ,
                                          String AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV67Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV70Sedewwds_13_tfubigeocode_sel ,
                                          String AV69Sedewwds_12_tfubigeocode ,
                                          String AV72Sedewwds_15_tfubigeonombre_sel ,
                                          String AV71Sedewwds_14_tfubigeonombre ,
                                          String AV74Sedewwds_17_tfsededireccion_sel ,
                                          String AV73Sedewwds_16_tfsededireccion ,
                                          String AV76Sedewwds_19_tfsedecorreo_sel ,
                                          String AV75Sedewwds_18_tfsedecorreo ,
                                          int AV77Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV78Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV79Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          String AV58Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[38];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT T1.[SedeDireccion], T2.[ClinicaRUC], T1.[ClinicaId], T1.[SedeId], T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeCorreo], T3.[UbigeoDepartamento]" ;
      scmdbuf += " + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] AS UbigeoNombre, T1.[UbigeoCode], T2.[ClinicaNombreComercial], T1.[SedeNombre], T3.[UbigeoDepartamento]," ;
      scmdbuf += " T3.[UbigeoProvincia], T3.[UbigeoDistrito] FROM (([Sede] T1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = T1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode]" ;
      scmdbuf += " = T1.[UbigeoCode])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T2.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T2.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV59Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int16[20] = (byte)(1) ;
      }
      if ( ! (0==AV60Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int16[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV61Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int16[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int16[23] = (byte)(1) ;
      }
      if ( ! (0==AV63Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int16[24] = (byte)(1) ;
      }
      if ( ! (0==AV64Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int16[25] = (byte)(1) ;
      }
      if ( ! (0==AV65Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int16[26] = (byte)(1) ;
      }
      if ( ! (0==AV66Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int16[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV67Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int16[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int16[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV69Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int16[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int16[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV71Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int16[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int16[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV73Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int16[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int16[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int16[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int16[37] = (byte)(1) ;
      }
      if ( AV77Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV78Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV78Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV79Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV79Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SedeDireccion]" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P003V7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV77Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV78Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV79Sedewwds_22_tfsedesector_sels ,
                                          short AV59Sedewwds_2_tfsedeid ,
                                          short AV60Sedewwds_3_tfsedeid_to ,
                                          String AV62Sedewwds_5_tfsedenombre_sel ,
                                          String AV61Sedewwds_4_tfsedenombre ,
                                          short AV63Sedewwds_6_tfclinicaid ,
                                          short AV64Sedewwds_7_tfclinicaid_to ,
                                          long AV65Sedewwds_8_tfclinicaruc ,
                                          long AV66Sedewwds_9_tfclinicaruc_to ,
                                          String AV68Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV67Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV70Sedewwds_13_tfubigeocode_sel ,
                                          String AV69Sedewwds_12_tfubigeocode ,
                                          String AV72Sedewwds_15_tfubigeonombre_sel ,
                                          String AV71Sedewwds_14_tfubigeonombre ,
                                          String AV74Sedewwds_17_tfsededireccion_sel ,
                                          String AV73Sedewwds_16_tfsededireccion ,
                                          String AV76Sedewwds_19_tfsedecorreo_sel ,
                                          String AV75Sedewwds_18_tfsedecorreo ,
                                          int AV77Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV78Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV79Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          String AV58Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[38];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT T1.[SedeCorreo], T2.[ClinicaRUC], T1.[ClinicaId], T1.[SedeId], T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeDireccion], T3.[UbigeoDepartamento]" ;
      scmdbuf += " + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] AS UbigeoNombre, T1.[UbigeoCode], T2.[ClinicaNombreComercial], T1.[SedeNombre], T3.[UbigeoDepartamento]," ;
      scmdbuf += " T3.[UbigeoProvincia], T3.[UbigeoDistrito] FROM (([Sede] T1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = T1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode]" ;
      scmdbuf += " = T1.[UbigeoCode])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T2.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T2.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV59Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int19[20] = (byte)(1) ;
      }
      if ( ! (0==AV60Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int19[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV61Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int19[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int19[23] = (byte)(1) ;
      }
      if ( ! (0==AV63Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int19[24] = (byte)(1) ;
      }
      if ( ! (0==AV64Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int19[25] = (byte)(1) ;
      }
      if ( ! (0==AV65Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int19[26] = (byte)(1) ;
      }
      if ( ! (0==AV66Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int19[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV67Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int19[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int19[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV69Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int19[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int19[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV71Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int19[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int19[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV73Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int19[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int19[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int19[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int19[37] = (byte)(1) ;
      }
      if ( AV77Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV78Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV78Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV79Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV79Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SedeCorreo]" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
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
                  return conditional_P003V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] );
            case 1 :
                  return conditional_P003V3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] );
            case 2 :
                  return conditional_P003V4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] );
            case 3 :
                  return conditional_P003V5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] );
            case 4 :
                  return conditional_P003V6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] );
            case 5 :
                  return conditional_P003V7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 10);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 10);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
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
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
      }
   }

}

