package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clinicawwgetfilterdata extends GXProcedure
{
   public clinicawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clinicawwgetfilterdata.class ), "" );
   }

   public clinicawwgetfilterdata( int remoteHandle ,
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
      clinicawwgetfilterdata.this.aP5 = new String[] {""};
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
      clinicawwgetfilterdata.this.AV43DDOName = aP0;
      clinicawwgetfilterdata.this.AV41SearchTxt = aP1;
      clinicawwgetfilterdata.this.AV42SearchTxtTo = aP2;
      clinicawwgetfilterdata.this.aP3 = aP3;
      clinicawwgetfilterdata.this.aP4 = aP4;
      clinicawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV46Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica", GXv_boolean2) ;
      clinicawwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICANOMBRECOMERCIAL") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICANOMBRECOMERCIALOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICANOMBREABREVIADO") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICANOMBREABREVIADOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICADIRECCIONCOMERCIAL") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICADIRECCIONCOMERCIALOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICACORREO") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICACORREOOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICATELEFONO") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICATELEFONOOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICAWHATSAPP") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICAWHATSAPPOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICAFACEBOOK") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICAFACEBOOKOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICATWITER") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICATWITEROPTIONS' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICAINSTAGRAM") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICAINSTAGRAMOPTIONS' */
            S201 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CLINICALINKEDIN") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINICALINKEDINOPTIONS' */
            S211 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV47OptionsJson = AV46Options.toJSonString(false) ;
      AV50OptionsDescJson = AV49OptionsDesc.toJSonString(false) ;
      AV52OptionIndexesJson = AV51OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV54Session.getValue("ClinicaWWGridState"), "") == 0 )
      {
         AV56GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClinicaWWGridState"), null, null);
      }
      else
      {
         AV56GridState.fromxml(AV54Session.getValue("ClinicaWWGridState"), null, null);
      }
      AV62GXV1 = 1 ;
      while ( AV62GXV1 <= AV56GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV57GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV56GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV62GXV1));
         if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV59FilterFullText = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAID") == 0 )
         {
            AV11TFClinicaId = (short)(GXutil.lval( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFClinicaId_To = (short)(GXutil.lval( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICARUC") == 0 )
         {
            AV13TFClinicaRUC = GXutil.lval( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV14TFClinicaRUC_To = GXutil.lval( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL") == 0 )
         {
            AV15TFClinicaNombreComercial = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL_SEL") == 0 )
         {
            AV16TFClinicaNombreComercial_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBREABREVIADO") == 0 )
         {
            AV17TFClinicaNombreAbreviado = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBREABREVIADO_SEL") == 0 )
         {
            AV18TFClinicaNombreAbreviado_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICADIRECCIONCOMERCIAL") == 0 )
         {
            AV19TFClinicaDireccionComercial = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICADIRECCIONCOMERCIAL_SEL") == 0 )
         {
            AV20TFClinicaDireccionComercial_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICACORREO") == 0 )
         {
            AV21TFClinicaCorreo = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICACORREO_SEL") == 0 )
         {
            AV22TFClinicaCorreo_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAMONEDA_SEL") == 0 )
         {
            AV23TFClinicaMoneda_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFClinicaMoneda_Sels.fromJSonString(AV23TFClinicaMoneda_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATELEFONO") == 0 )
         {
            AV25TFClinicaTelefono = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATELEFONO_SEL") == 0 )
         {
            AV26TFClinicaTelefono_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAWHATSAPP") == 0 )
         {
            AV27TFClinicaWhatsApp = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAWHATSAPP_SEL") == 0 )
         {
            AV28TFClinicaWhatsApp_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAFACEBOOK") == 0 )
         {
            AV29TFClinicaFacebook = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAFACEBOOK_SEL") == 0 )
         {
            AV30TFClinicaFacebook_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATWITER") == 0 )
         {
            AV31TFClinicaTwiter = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATWITER_SEL") == 0 )
         {
            AV32TFClinicaTwiter_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAINSTAGRAM") == 0 )
         {
            AV33TFClinicaInstagram = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAINSTAGRAM_SEL") == 0 )
         {
            AV34TFClinicaInstagram_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICALINKEDIN") == 0 )
         {
            AV35TFClinicaLinkedin = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICALINKEDIN_SEL") == 0 )
         {
            AV36TFClinicaLinkedin_Sel = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATIEMPODECITA_SEL") == 0 )
         {
            AV37TFClinicaTiempoDeCita_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFClinicaTiempoDeCita_Sels.fromJSonString(AV37TFClinicaTiempoDeCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAESTADO_SEL") == 0 )
         {
            AV39TFClinicaEstado_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFClinicaEstado_Sels.fromJSonString(AV39TFClinicaEstado_SelsJson, null);
         }
         AV62GXV1 = (int)(AV62GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCLINICANOMBRECOMERCIALOPTIONS' Routine */
      returnInSub = false ;
      AV15TFClinicaNombreComercial = AV41SearchTxt ;
      AV16TFClinicaNombreComercial_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T2 */
      pr_default.execute(0, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2T2 = false ;
         A116ClinicaNombreComercial = P002T2_A116ClinicaNombreComercial[0] ;
         A118ClinicaRUC = P002T2_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T2_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T2_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T2_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T2_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P002T2_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P002T2_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P002T2_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P002T2_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P002T2_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T2_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T2_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P002T2_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P002T2_A80ClinicaNombreAbreviado[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P002T2_A116ClinicaNombreComercial[0], A116ClinicaNombreComercial) == 0 ) )
         {
            brk2T2 = false ;
            A28ClinicaId = P002T2_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A116ClinicaNombreComercial)==0) )
         {
            AV45Option = A116ClinicaNombreComercial ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T2 )
         {
            brk2T2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCLINICANOMBREABREVIADOOPTIONS' Routine */
      returnInSub = false ;
      AV17TFClinicaNombreAbreviado = AV41SearchTxt ;
      AV18TFClinicaNombreAbreviado_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T3 */
      pr_default.execute(1, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2T4 = false ;
         A80ClinicaNombreAbreviado = P002T3_A80ClinicaNombreAbreviado[0] ;
         A118ClinicaRUC = P002T3_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T3_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T3_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T3_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T3_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P002T3_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P002T3_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P002T3_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P002T3_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P002T3_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T3_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T3_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P002T3_A119ClinicaDireccionComercial[0] ;
         A116ClinicaNombreComercial = P002T3_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P002T3_A80ClinicaNombreAbreviado[0], A80ClinicaNombreAbreviado) == 0 ) )
         {
            brk2T4 = false ;
            A28ClinicaId = P002T3_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A80ClinicaNombreAbreviado)==0) )
         {
            AV45Option = A80ClinicaNombreAbreviado ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T4 )
         {
            brk2T4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCLINICADIRECCIONCOMERCIALOPTIONS' Routine */
      returnInSub = false ;
      AV19TFClinicaDireccionComercial = AV41SearchTxt ;
      AV20TFClinicaDireccionComercial_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T4 */
      pr_default.execute(2, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk2T6 = false ;
         A119ClinicaDireccionComercial = P002T4_A119ClinicaDireccionComercial[0] ;
         A118ClinicaRUC = P002T4_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T4_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T4_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T4_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T4_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P002T4_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P002T4_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P002T4_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P002T4_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P002T4_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T4_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T4_A340ClinicaCorreo[0] ;
         A80ClinicaNombreAbreviado = P002T4_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P002T4_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P002T4_A119ClinicaDireccionComercial[0], A119ClinicaDireccionComercial) == 0 ) )
         {
            brk2T6 = false ;
            A28ClinicaId = P002T4_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A119ClinicaDireccionComercial)==0) )
         {
            AV45Option = A119ClinicaDireccionComercial ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T6 )
         {
            brk2T6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADCLINICACORREOOPTIONS' Routine */
      returnInSub = false ;
      AV21TFClinicaCorreo = AV41SearchTxt ;
      AV22TFClinicaCorreo_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T5 */
      pr_default.execute(3, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk2T8 = false ;
         A340ClinicaCorreo = P002T5_A340ClinicaCorreo[0] ;
         A118ClinicaRUC = P002T5_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T5_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T5_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T5_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T5_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P002T5_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P002T5_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P002T5_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P002T5_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P002T5_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T5_A341ClinicaMoneda[0] ;
         A119ClinicaDireccionComercial = P002T5_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P002T5_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P002T5_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P002T5_A340ClinicaCorreo[0], A340ClinicaCorreo) == 0 ) )
         {
            brk2T8 = false ;
            A28ClinicaId = P002T5_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A340ClinicaCorreo)==0) )
         {
            AV45Option = A340ClinicaCorreo ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T8 )
         {
            brk2T8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADCLINICATELEFONOOPTIONS' Routine */
      returnInSub = false ;
      AV25TFClinicaTelefono = AV41SearchTxt ;
      AV26TFClinicaTelefono_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T6 */
      pr_default.execute(4, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk2T10 = false ;
         A346ClinicaTelefono = P002T6_A346ClinicaTelefono[0] ;
         A118ClinicaRUC = P002T6_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T6_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T6_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T6_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T6_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P002T6_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P002T6_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P002T6_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P002T6_A347ClinicaWhatsApp[0] ;
         A341ClinicaMoneda = P002T6_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T6_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P002T6_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P002T6_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P002T6_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P002T6_A346ClinicaTelefono[0], A346ClinicaTelefono) == 0 ) )
         {
            brk2T10 = false ;
            A28ClinicaId = P002T6_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A346ClinicaTelefono)==0) )
         {
            AV45Option = A346ClinicaTelefono ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T10 )
         {
            brk2T10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADCLINICAWHATSAPPOPTIONS' Routine */
      returnInSub = false ;
      AV27TFClinicaWhatsApp = AV41SearchTxt ;
      AV28TFClinicaWhatsApp_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T7 */
      pr_default.execute(5, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk2T12 = false ;
         A347ClinicaWhatsApp = P002T7_A347ClinicaWhatsApp[0] ;
         A118ClinicaRUC = P002T7_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T7_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T7_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T7_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T7_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P002T7_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P002T7_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P002T7_A348ClinicaFacebook[0] ;
         A346ClinicaTelefono = P002T7_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T7_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T7_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P002T7_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P002T7_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P002T7_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P002T7_A347ClinicaWhatsApp[0], A347ClinicaWhatsApp) == 0 ) )
         {
            brk2T12 = false ;
            A28ClinicaId = P002T7_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A347ClinicaWhatsApp)==0) )
         {
            AV45Option = A347ClinicaWhatsApp ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T12 )
         {
            brk2T12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADCLINICAFACEBOOKOPTIONS' Routine */
      returnInSub = false ;
      AV29TFClinicaFacebook = AV41SearchTxt ;
      AV30TFClinicaFacebook_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T8 */
      pr_default.execute(6, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk2T14 = false ;
         A348ClinicaFacebook = P002T8_A348ClinicaFacebook[0] ;
         A118ClinicaRUC = P002T8_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T8_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T8_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T8_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T8_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P002T8_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P002T8_A349ClinicaTwiter[0] ;
         A347ClinicaWhatsApp = P002T8_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P002T8_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T8_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T8_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P002T8_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P002T8_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P002T8_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( GXutil.strcmp(P002T8_A348ClinicaFacebook[0], A348ClinicaFacebook) == 0 ) )
         {
            brk2T14 = false ;
            A28ClinicaId = P002T8_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T14 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A348ClinicaFacebook)==0) )
         {
            AV45Option = A348ClinicaFacebook ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T14 )
         {
            brk2T14 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   public void S191( )
   {
      /* 'LOADCLINICATWITEROPTIONS' Routine */
      returnInSub = false ;
      AV31TFClinicaTwiter = AV41SearchTxt ;
      AV32TFClinicaTwiter_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T9 */
      pr_default.execute(7, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(7) != 101) )
      {
         brk2T16 = false ;
         A349ClinicaTwiter = P002T9_A349ClinicaTwiter[0] ;
         A118ClinicaRUC = P002T9_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T9_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T9_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T9_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T9_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P002T9_A350ClinicaInstagram[0] ;
         A348ClinicaFacebook = P002T9_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P002T9_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P002T9_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T9_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T9_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P002T9_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P002T9_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P002T9_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(7) != 101) && ( GXutil.strcmp(P002T9_A349ClinicaTwiter[0], A349ClinicaTwiter) == 0 ) )
         {
            brk2T16 = false ;
            A28ClinicaId = P002T9_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T16 = true ;
            pr_default.readNext(7);
         }
         if ( ! (GXutil.strcmp("", A349ClinicaTwiter)==0) )
         {
            AV45Option = A349ClinicaTwiter ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T16 )
         {
            brk2T16 = true ;
            pr_default.readNext(7);
         }
      }
      pr_default.close(7);
   }

   public void S201( )
   {
      /* 'LOADCLINICAINSTAGRAMOPTIONS' Routine */
      returnInSub = false ;
      AV33TFClinicaInstagram = AV41SearchTxt ;
      AV34TFClinicaInstagram_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(8, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T10 */
      pr_default.execute(8, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(8) != 101) )
      {
         brk2T18 = false ;
         A350ClinicaInstagram = P002T10_A350ClinicaInstagram[0] ;
         A118ClinicaRUC = P002T10_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T10_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T10_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T10_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P002T10_A351ClinicaLinkedin[0] ;
         A349ClinicaTwiter = P002T10_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P002T10_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P002T10_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P002T10_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T10_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T10_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P002T10_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P002T10_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P002T10_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(8) != 101) && ( GXutil.strcmp(P002T10_A350ClinicaInstagram[0], A350ClinicaInstagram) == 0 ) )
         {
            brk2T18 = false ;
            A28ClinicaId = P002T10_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T18 = true ;
            pr_default.readNext(8);
         }
         if ( ! (GXutil.strcmp("", A350ClinicaInstagram)==0) )
         {
            AV45Option = A350ClinicaInstagram ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T18 )
         {
            brk2T18 = true ;
            pr_default.readNext(8);
         }
      }
      pr_default.close(8);
   }

   public void S211( )
   {
      /* 'LOADCLINICALINKEDINOPTIONS' Routine */
      returnInSub = false ;
      AV35TFClinicaLinkedin = AV41SearchTxt ;
      AV36TFClinicaLinkedin_Sel = "" ;
      AV64Clinicawwds_1_filterfulltext = AV59FilterFullText ;
      AV65Clinicawwds_2_tfclinicaid = AV11TFClinicaId ;
      AV66Clinicawwds_3_tfclinicaid_to = AV12TFClinicaId_To ;
      AV67Clinicawwds_4_tfclinicaruc = AV13TFClinicaRUC ;
      AV68Clinicawwds_5_tfclinicaruc_to = AV14TFClinicaRUC_To ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = AV15TFClinicaNombreComercial ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = AV16TFClinicaNombreComercial_Sel ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = AV17TFClinicaNombreAbreviado ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = AV18TFClinicaNombreAbreviado_Sel ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = AV19TFClinicaDireccionComercial ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = AV20TFClinicaDireccionComercial_Sel ;
      AV75Clinicawwds_12_tfclinicacorreo = AV21TFClinicaCorreo ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = AV22TFClinicaCorreo_Sel ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = AV24TFClinicaMoneda_Sels ;
      AV78Clinicawwds_15_tfclinicatelefono = AV25TFClinicaTelefono ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = AV26TFClinicaTelefono_Sel ;
      AV80Clinicawwds_17_tfclinicawhatsapp = AV27TFClinicaWhatsApp ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = AV28TFClinicaWhatsApp_Sel ;
      AV82Clinicawwds_19_tfclinicafacebook = AV29TFClinicaFacebook ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = AV30TFClinicaFacebook_Sel ;
      AV84Clinicawwds_21_tfclinicatwiter = AV31TFClinicaTwiter ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = AV32TFClinicaTwiter_Sel ;
      AV86Clinicawwds_23_tfclinicainstagram = AV33TFClinicaInstagram ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = AV34TFClinicaInstagram_Sel ;
      AV88Clinicawwds_25_tfclinicalinkedin = AV35TFClinicaLinkedin ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = AV36TFClinicaLinkedin_Sel ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = AV38TFClinicaTiempoDeCita_Sels ;
      AV91Clinicawwds_28_tfclinicaestado_sels = AV40TFClinicaEstado_Sels ;
      pr_default.dynParam(9, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           AV64Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV67Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to) ,
                                           AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV75Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV77Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV78Clinicawwds_15_tfclinicatelefono ,
                                           AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV82Clinicawwds_19_tfclinicafacebook ,
                                           AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV84Clinicawwds_21_tfclinicatwiter ,
                                           AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV86Clinicawwds_23_tfclinicainstagram ,
                                           AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV88Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV90Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV91Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV64Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Clinicawwds_1_filterfulltext), "%", "") ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV69Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV71Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV75Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV78Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV78Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV80Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV80Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV82Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV84Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV86Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV88Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P002T11 */
      pr_default.execute(9, new Object[] {lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, lV64Clinicawwds_1_filterfulltext, Short.valueOf(AV65Clinicawwds_2_tfclinicaid), Short.valueOf(AV66Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV67Clinicawwds_4_tfclinicaruc), Long.valueOf(AV68Clinicawwds_5_tfclinicaruc_to), lV69Clinicawwds_6_tfclinicanombrecomercial, AV70Clinicawwds_7_tfclinicanombrecomercial_sel, lV71Clinicawwds_8_tfclinicanombreabreviado, AV72Clinicawwds_9_tfclinicanombreabreviado_sel, lV73Clinicawwds_10_tfclinicadireccioncomercial, AV74Clinicawwds_11_tfclinicadireccioncomercial_sel, lV75Clinicawwds_12_tfclinicacorreo, AV76Clinicawwds_13_tfclinicacorreo_sel, lV78Clinicawwds_15_tfclinicatelefono, AV79Clinicawwds_16_tfclinicatelefono_sel, lV80Clinicawwds_17_tfclinicawhatsapp, AV81Clinicawwds_18_tfclinicawhatsapp_sel, lV82Clinicawwds_19_tfclinicafacebook, AV83Clinicawwds_20_tfclinicafacebook_sel, lV84Clinicawwds_21_tfclinicatwiter, AV85Clinicawwds_22_tfclinicatwiter_sel, lV86Clinicawwds_23_tfclinicainstagram, AV87Clinicawwds_24_tfclinicainstagram_sel, lV88Clinicawwds_25_tfclinicalinkedin, AV89Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(9) != 101) )
      {
         brk2T20 = false ;
         A351ClinicaLinkedin = P002T11_A351ClinicaLinkedin[0] ;
         A118ClinicaRUC = P002T11_A118ClinicaRUC[0] ;
         A28ClinicaId = P002T11_A28ClinicaId[0] ;
         A121ClinicaEstado = P002T11_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P002T11_A120ClinicaTiempoDeCita[0] ;
         A350ClinicaInstagram = P002T11_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P002T11_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P002T11_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P002T11_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P002T11_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P002T11_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P002T11_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P002T11_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P002T11_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P002T11_A116ClinicaNombreComercial[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(9) != 101) && ( GXutil.strcmp(P002T11_A351ClinicaLinkedin[0], A351ClinicaLinkedin) == 0 ) )
         {
            brk2T20 = false ;
            A28ClinicaId = P002T11_A28ClinicaId[0] ;
            AV53count = (long)(AV53count+1) ;
            brk2T20 = true ;
            pr_default.readNext(9);
         }
         if ( ! (GXutil.strcmp("", A351ClinicaLinkedin)==0) )
         {
            AV45Option = A351ClinicaLinkedin ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2T20 )
         {
            brk2T20 = true ;
            pr_default.readNext(9);
         }
      }
      pr_default.close(9);
   }

   protected void cleanup( )
   {
      this.aP3[0] = clinicawwgetfilterdata.this.AV47OptionsJson;
      this.aP4[0] = clinicawwgetfilterdata.this.AV50OptionsDescJson;
      this.aP5[0] = clinicawwgetfilterdata.this.AV52OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV47OptionsJson = "" ;
      AV50OptionsDescJson = "" ;
      AV52OptionIndexesJson = "" ;
      AV46Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV54Session = httpContext.getWebSession();
      AV56GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV57GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV59FilterFullText = "" ;
      AV15TFClinicaNombreComercial = "" ;
      AV16TFClinicaNombreComercial_Sel = "" ;
      AV17TFClinicaNombreAbreviado = "" ;
      AV18TFClinicaNombreAbreviado_Sel = "" ;
      AV19TFClinicaDireccionComercial = "" ;
      AV20TFClinicaDireccionComercial_Sel = "" ;
      AV21TFClinicaCorreo = "" ;
      AV22TFClinicaCorreo_Sel = "" ;
      AV23TFClinicaMoneda_SelsJson = "" ;
      AV24TFClinicaMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV25TFClinicaTelefono = "" ;
      AV26TFClinicaTelefono_Sel = "" ;
      AV27TFClinicaWhatsApp = "" ;
      AV28TFClinicaWhatsApp_Sel = "" ;
      AV29TFClinicaFacebook = "" ;
      AV30TFClinicaFacebook_Sel = "" ;
      AV31TFClinicaTwiter = "" ;
      AV32TFClinicaTwiter_Sel = "" ;
      AV33TFClinicaInstagram = "" ;
      AV34TFClinicaInstagram_Sel = "" ;
      AV35TFClinicaLinkedin = "" ;
      AV36TFClinicaLinkedin_Sel = "" ;
      AV37TFClinicaTiempoDeCita_SelsJson = "" ;
      AV38TFClinicaTiempoDeCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV39TFClinicaEstado_SelsJson = "" ;
      AV40TFClinicaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A116ClinicaNombreComercial = "" ;
      AV64Clinicawwds_1_filterfulltext = "" ;
      AV69Clinicawwds_6_tfclinicanombrecomercial = "" ;
      AV70Clinicawwds_7_tfclinicanombrecomercial_sel = "" ;
      AV71Clinicawwds_8_tfclinicanombreabreviado = "" ;
      AV72Clinicawwds_9_tfclinicanombreabreviado_sel = "" ;
      AV73Clinicawwds_10_tfclinicadireccioncomercial = "" ;
      AV74Clinicawwds_11_tfclinicadireccioncomercial_sel = "" ;
      AV75Clinicawwds_12_tfclinicacorreo = "" ;
      AV76Clinicawwds_13_tfclinicacorreo_sel = "" ;
      AV77Clinicawwds_14_tfclinicamoneda_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV78Clinicawwds_15_tfclinicatelefono = "" ;
      AV79Clinicawwds_16_tfclinicatelefono_sel = "" ;
      AV80Clinicawwds_17_tfclinicawhatsapp = "" ;
      AV81Clinicawwds_18_tfclinicawhatsapp_sel = "" ;
      AV82Clinicawwds_19_tfclinicafacebook = "" ;
      AV83Clinicawwds_20_tfclinicafacebook_sel = "" ;
      AV84Clinicawwds_21_tfclinicatwiter = "" ;
      AV85Clinicawwds_22_tfclinicatwiter_sel = "" ;
      AV86Clinicawwds_23_tfclinicainstagram = "" ;
      AV87Clinicawwds_24_tfclinicainstagram_sel = "" ;
      AV88Clinicawwds_25_tfclinicalinkedin = "" ;
      AV89Clinicawwds_26_tfclinicalinkedin_sel = "" ;
      AV90Clinicawwds_27_tfclinicatiempodecita_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV91Clinicawwds_28_tfclinicaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV64Clinicawwds_1_filterfulltext = "" ;
      lV69Clinicawwds_6_tfclinicanombrecomercial = "" ;
      lV71Clinicawwds_8_tfclinicanombreabreviado = "" ;
      lV73Clinicawwds_10_tfclinicadireccioncomercial = "" ;
      lV75Clinicawwds_12_tfclinicacorreo = "" ;
      lV78Clinicawwds_15_tfclinicatelefono = "" ;
      lV80Clinicawwds_17_tfclinicawhatsapp = "" ;
      lV82Clinicawwds_19_tfclinicafacebook = "" ;
      lV84Clinicawwds_21_tfclinicatwiter = "" ;
      lV86Clinicawwds_23_tfclinicainstagram = "" ;
      lV88Clinicawwds_25_tfclinicalinkedin = "" ;
      A121ClinicaEstado = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A119ClinicaDireccionComercial = "" ;
      A340ClinicaCorreo = "" ;
      A346ClinicaTelefono = "" ;
      A347ClinicaWhatsApp = "" ;
      A348ClinicaFacebook = "" ;
      A349ClinicaTwiter = "" ;
      A350ClinicaInstagram = "" ;
      A351ClinicaLinkedin = "" ;
      P002T2_A116ClinicaNombreComercial = new String[] {""} ;
      P002T2_A118ClinicaRUC = new long[1] ;
      P002T2_A28ClinicaId = new short[1] ;
      P002T2_A121ClinicaEstado = new String[] {""} ;
      P002T2_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T2_A351ClinicaLinkedin = new String[] {""} ;
      P002T2_A350ClinicaInstagram = new String[] {""} ;
      P002T2_A349ClinicaTwiter = new String[] {""} ;
      P002T2_A348ClinicaFacebook = new String[] {""} ;
      P002T2_A347ClinicaWhatsApp = new String[] {""} ;
      P002T2_A346ClinicaTelefono = new String[] {""} ;
      P002T2_A341ClinicaMoneda = new short[1] ;
      P002T2_A340ClinicaCorreo = new String[] {""} ;
      P002T2_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T2_A80ClinicaNombreAbreviado = new String[] {""} ;
      AV45Option = "" ;
      P002T3_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T3_A118ClinicaRUC = new long[1] ;
      P002T3_A28ClinicaId = new short[1] ;
      P002T3_A121ClinicaEstado = new String[] {""} ;
      P002T3_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T3_A351ClinicaLinkedin = new String[] {""} ;
      P002T3_A350ClinicaInstagram = new String[] {""} ;
      P002T3_A349ClinicaTwiter = new String[] {""} ;
      P002T3_A348ClinicaFacebook = new String[] {""} ;
      P002T3_A347ClinicaWhatsApp = new String[] {""} ;
      P002T3_A346ClinicaTelefono = new String[] {""} ;
      P002T3_A341ClinicaMoneda = new short[1] ;
      P002T3_A340ClinicaCorreo = new String[] {""} ;
      P002T3_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T3_A116ClinicaNombreComercial = new String[] {""} ;
      P002T4_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T4_A118ClinicaRUC = new long[1] ;
      P002T4_A28ClinicaId = new short[1] ;
      P002T4_A121ClinicaEstado = new String[] {""} ;
      P002T4_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T4_A351ClinicaLinkedin = new String[] {""} ;
      P002T4_A350ClinicaInstagram = new String[] {""} ;
      P002T4_A349ClinicaTwiter = new String[] {""} ;
      P002T4_A348ClinicaFacebook = new String[] {""} ;
      P002T4_A347ClinicaWhatsApp = new String[] {""} ;
      P002T4_A346ClinicaTelefono = new String[] {""} ;
      P002T4_A341ClinicaMoneda = new short[1] ;
      P002T4_A340ClinicaCorreo = new String[] {""} ;
      P002T4_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T4_A116ClinicaNombreComercial = new String[] {""} ;
      P002T5_A340ClinicaCorreo = new String[] {""} ;
      P002T5_A118ClinicaRUC = new long[1] ;
      P002T5_A28ClinicaId = new short[1] ;
      P002T5_A121ClinicaEstado = new String[] {""} ;
      P002T5_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T5_A351ClinicaLinkedin = new String[] {""} ;
      P002T5_A350ClinicaInstagram = new String[] {""} ;
      P002T5_A349ClinicaTwiter = new String[] {""} ;
      P002T5_A348ClinicaFacebook = new String[] {""} ;
      P002T5_A347ClinicaWhatsApp = new String[] {""} ;
      P002T5_A346ClinicaTelefono = new String[] {""} ;
      P002T5_A341ClinicaMoneda = new short[1] ;
      P002T5_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T5_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T5_A116ClinicaNombreComercial = new String[] {""} ;
      P002T6_A346ClinicaTelefono = new String[] {""} ;
      P002T6_A118ClinicaRUC = new long[1] ;
      P002T6_A28ClinicaId = new short[1] ;
      P002T6_A121ClinicaEstado = new String[] {""} ;
      P002T6_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T6_A351ClinicaLinkedin = new String[] {""} ;
      P002T6_A350ClinicaInstagram = new String[] {""} ;
      P002T6_A349ClinicaTwiter = new String[] {""} ;
      P002T6_A348ClinicaFacebook = new String[] {""} ;
      P002T6_A347ClinicaWhatsApp = new String[] {""} ;
      P002T6_A341ClinicaMoneda = new short[1] ;
      P002T6_A340ClinicaCorreo = new String[] {""} ;
      P002T6_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T6_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T6_A116ClinicaNombreComercial = new String[] {""} ;
      P002T7_A347ClinicaWhatsApp = new String[] {""} ;
      P002T7_A118ClinicaRUC = new long[1] ;
      P002T7_A28ClinicaId = new short[1] ;
      P002T7_A121ClinicaEstado = new String[] {""} ;
      P002T7_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T7_A351ClinicaLinkedin = new String[] {""} ;
      P002T7_A350ClinicaInstagram = new String[] {""} ;
      P002T7_A349ClinicaTwiter = new String[] {""} ;
      P002T7_A348ClinicaFacebook = new String[] {""} ;
      P002T7_A346ClinicaTelefono = new String[] {""} ;
      P002T7_A341ClinicaMoneda = new short[1] ;
      P002T7_A340ClinicaCorreo = new String[] {""} ;
      P002T7_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T7_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T7_A116ClinicaNombreComercial = new String[] {""} ;
      P002T8_A348ClinicaFacebook = new String[] {""} ;
      P002T8_A118ClinicaRUC = new long[1] ;
      P002T8_A28ClinicaId = new short[1] ;
      P002T8_A121ClinicaEstado = new String[] {""} ;
      P002T8_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T8_A351ClinicaLinkedin = new String[] {""} ;
      P002T8_A350ClinicaInstagram = new String[] {""} ;
      P002T8_A349ClinicaTwiter = new String[] {""} ;
      P002T8_A347ClinicaWhatsApp = new String[] {""} ;
      P002T8_A346ClinicaTelefono = new String[] {""} ;
      P002T8_A341ClinicaMoneda = new short[1] ;
      P002T8_A340ClinicaCorreo = new String[] {""} ;
      P002T8_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T8_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T8_A116ClinicaNombreComercial = new String[] {""} ;
      P002T9_A349ClinicaTwiter = new String[] {""} ;
      P002T9_A118ClinicaRUC = new long[1] ;
      P002T9_A28ClinicaId = new short[1] ;
      P002T9_A121ClinicaEstado = new String[] {""} ;
      P002T9_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T9_A351ClinicaLinkedin = new String[] {""} ;
      P002T9_A350ClinicaInstagram = new String[] {""} ;
      P002T9_A348ClinicaFacebook = new String[] {""} ;
      P002T9_A347ClinicaWhatsApp = new String[] {""} ;
      P002T9_A346ClinicaTelefono = new String[] {""} ;
      P002T9_A341ClinicaMoneda = new short[1] ;
      P002T9_A340ClinicaCorreo = new String[] {""} ;
      P002T9_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T9_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T9_A116ClinicaNombreComercial = new String[] {""} ;
      P002T10_A350ClinicaInstagram = new String[] {""} ;
      P002T10_A118ClinicaRUC = new long[1] ;
      P002T10_A28ClinicaId = new short[1] ;
      P002T10_A121ClinicaEstado = new String[] {""} ;
      P002T10_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T10_A351ClinicaLinkedin = new String[] {""} ;
      P002T10_A349ClinicaTwiter = new String[] {""} ;
      P002T10_A348ClinicaFacebook = new String[] {""} ;
      P002T10_A347ClinicaWhatsApp = new String[] {""} ;
      P002T10_A346ClinicaTelefono = new String[] {""} ;
      P002T10_A341ClinicaMoneda = new short[1] ;
      P002T10_A340ClinicaCorreo = new String[] {""} ;
      P002T10_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T10_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T10_A116ClinicaNombreComercial = new String[] {""} ;
      P002T11_A351ClinicaLinkedin = new String[] {""} ;
      P002T11_A118ClinicaRUC = new long[1] ;
      P002T11_A28ClinicaId = new short[1] ;
      P002T11_A121ClinicaEstado = new String[] {""} ;
      P002T11_A120ClinicaTiempoDeCita = new byte[1] ;
      P002T11_A350ClinicaInstagram = new String[] {""} ;
      P002T11_A349ClinicaTwiter = new String[] {""} ;
      P002T11_A348ClinicaFacebook = new String[] {""} ;
      P002T11_A347ClinicaWhatsApp = new String[] {""} ;
      P002T11_A346ClinicaTelefono = new String[] {""} ;
      P002T11_A341ClinicaMoneda = new short[1] ;
      P002T11_A340ClinicaCorreo = new String[] {""} ;
      P002T11_A119ClinicaDireccionComercial = new String[] {""} ;
      P002T11_A80ClinicaNombreAbreviado = new String[] {""} ;
      P002T11_A116ClinicaNombreComercial = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.clinicawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P002T2_A116ClinicaNombreComercial, P002T2_A118ClinicaRUC, P002T2_A28ClinicaId, P002T2_A121ClinicaEstado, P002T2_A120ClinicaTiempoDeCita, P002T2_A351ClinicaLinkedin, P002T2_A350ClinicaInstagram, P002T2_A349ClinicaTwiter, P002T2_A348ClinicaFacebook, P002T2_A347ClinicaWhatsApp,
            P002T2_A346ClinicaTelefono, P002T2_A341ClinicaMoneda, P002T2_A340ClinicaCorreo, P002T2_A119ClinicaDireccionComercial, P002T2_A80ClinicaNombreAbreviado
            }
            , new Object[] {
            P002T3_A80ClinicaNombreAbreviado, P002T3_A118ClinicaRUC, P002T3_A28ClinicaId, P002T3_A121ClinicaEstado, P002T3_A120ClinicaTiempoDeCita, P002T3_A351ClinicaLinkedin, P002T3_A350ClinicaInstagram, P002T3_A349ClinicaTwiter, P002T3_A348ClinicaFacebook, P002T3_A347ClinicaWhatsApp,
            P002T3_A346ClinicaTelefono, P002T3_A341ClinicaMoneda, P002T3_A340ClinicaCorreo, P002T3_A119ClinicaDireccionComercial, P002T3_A116ClinicaNombreComercial
            }
            , new Object[] {
            P002T4_A119ClinicaDireccionComercial, P002T4_A118ClinicaRUC, P002T4_A28ClinicaId, P002T4_A121ClinicaEstado, P002T4_A120ClinicaTiempoDeCita, P002T4_A351ClinicaLinkedin, P002T4_A350ClinicaInstagram, P002T4_A349ClinicaTwiter, P002T4_A348ClinicaFacebook, P002T4_A347ClinicaWhatsApp,
            P002T4_A346ClinicaTelefono, P002T4_A341ClinicaMoneda, P002T4_A340ClinicaCorreo, P002T4_A80ClinicaNombreAbreviado, P002T4_A116ClinicaNombreComercial
            }
            , new Object[] {
            P002T5_A340ClinicaCorreo, P002T5_A118ClinicaRUC, P002T5_A28ClinicaId, P002T5_A121ClinicaEstado, P002T5_A120ClinicaTiempoDeCita, P002T5_A351ClinicaLinkedin, P002T5_A350ClinicaInstagram, P002T5_A349ClinicaTwiter, P002T5_A348ClinicaFacebook, P002T5_A347ClinicaWhatsApp,
            P002T5_A346ClinicaTelefono, P002T5_A341ClinicaMoneda, P002T5_A119ClinicaDireccionComercial, P002T5_A80ClinicaNombreAbreviado, P002T5_A116ClinicaNombreComercial
            }
            , new Object[] {
            P002T6_A346ClinicaTelefono, P002T6_A118ClinicaRUC, P002T6_A28ClinicaId, P002T6_A121ClinicaEstado, P002T6_A120ClinicaTiempoDeCita, P002T6_A351ClinicaLinkedin, P002T6_A350ClinicaInstagram, P002T6_A349ClinicaTwiter, P002T6_A348ClinicaFacebook, P002T6_A347ClinicaWhatsApp,
            P002T6_A341ClinicaMoneda, P002T6_A340ClinicaCorreo, P002T6_A119ClinicaDireccionComercial, P002T6_A80ClinicaNombreAbreviado, P002T6_A116ClinicaNombreComercial
            }
            , new Object[] {
            P002T7_A347ClinicaWhatsApp, P002T7_A118ClinicaRUC, P002T7_A28ClinicaId, P002T7_A121ClinicaEstado, P002T7_A120ClinicaTiempoDeCita, P002T7_A351ClinicaLinkedin, P002T7_A350ClinicaInstagram, P002T7_A349ClinicaTwiter, P002T7_A348ClinicaFacebook, P002T7_A346ClinicaTelefono,
            P002T7_A341ClinicaMoneda, P002T7_A340ClinicaCorreo, P002T7_A119ClinicaDireccionComercial, P002T7_A80ClinicaNombreAbreviado, P002T7_A116ClinicaNombreComercial
            }
            , new Object[] {
            P002T8_A348ClinicaFacebook, P002T8_A118ClinicaRUC, P002T8_A28ClinicaId, P002T8_A121ClinicaEstado, P002T8_A120ClinicaTiempoDeCita, P002T8_A351ClinicaLinkedin, P002T8_A350ClinicaInstagram, P002T8_A349ClinicaTwiter, P002T8_A347ClinicaWhatsApp, P002T8_A346ClinicaTelefono,
            P002T8_A341ClinicaMoneda, P002T8_A340ClinicaCorreo, P002T8_A119ClinicaDireccionComercial, P002T8_A80ClinicaNombreAbreviado, P002T8_A116ClinicaNombreComercial
            }
            , new Object[] {
            P002T9_A349ClinicaTwiter, P002T9_A118ClinicaRUC, P002T9_A28ClinicaId, P002T9_A121ClinicaEstado, P002T9_A120ClinicaTiempoDeCita, P002T9_A351ClinicaLinkedin, P002T9_A350ClinicaInstagram, P002T9_A348ClinicaFacebook, P002T9_A347ClinicaWhatsApp, P002T9_A346ClinicaTelefono,
            P002T9_A341ClinicaMoneda, P002T9_A340ClinicaCorreo, P002T9_A119ClinicaDireccionComercial, P002T9_A80ClinicaNombreAbreviado, P002T9_A116ClinicaNombreComercial
            }
            , new Object[] {
            P002T10_A350ClinicaInstagram, P002T10_A118ClinicaRUC, P002T10_A28ClinicaId, P002T10_A121ClinicaEstado, P002T10_A120ClinicaTiempoDeCita, P002T10_A351ClinicaLinkedin, P002T10_A349ClinicaTwiter, P002T10_A348ClinicaFacebook, P002T10_A347ClinicaWhatsApp, P002T10_A346ClinicaTelefono,
            P002T10_A341ClinicaMoneda, P002T10_A340ClinicaCorreo, P002T10_A119ClinicaDireccionComercial, P002T10_A80ClinicaNombreAbreviado, P002T10_A116ClinicaNombreComercial
            }
            , new Object[] {
            P002T11_A351ClinicaLinkedin, P002T11_A118ClinicaRUC, P002T11_A28ClinicaId, P002T11_A121ClinicaEstado, P002T11_A120ClinicaTiempoDeCita, P002T11_A350ClinicaInstagram, P002T11_A349ClinicaTwiter, P002T11_A348ClinicaFacebook, P002T11_A347ClinicaWhatsApp, P002T11_A346ClinicaTelefono,
            P002T11_A341ClinicaMoneda, P002T11_A340ClinicaCorreo, P002T11_A119ClinicaDireccionComercial, P002T11_A80ClinicaNombreAbreviado, P002T11_A116ClinicaNombreComercial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A120ClinicaTiempoDeCita ;
   private short AV11TFClinicaId ;
   private short AV12TFClinicaId_To ;
   private short AV65Clinicawwds_2_tfclinicaid ;
   private short AV66Clinicawwds_3_tfclinicaid_to ;
   private short A341ClinicaMoneda ;
   private short A28ClinicaId ;
   private short Gx_err ;
   private int AV62GXV1 ;
   private int AV77Clinicawwds_14_tfclinicamoneda_sels_size ;
   private int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ;
   private int AV91Clinicawwds_28_tfclinicaestado_sels_size ;
   private long AV13TFClinicaRUC ;
   private long AV14TFClinicaRUC_To ;
   private long AV67Clinicawwds_4_tfclinicaruc ;
   private long AV68Clinicawwds_5_tfclinicaruc_to ;
   private long A118ClinicaRUC ;
   private long AV53count ;
   private String AV25TFClinicaTelefono ;
   private String AV26TFClinicaTelefono_Sel ;
   private String AV27TFClinicaWhatsApp ;
   private String AV28TFClinicaWhatsApp_Sel ;
   private String AV78Clinicawwds_15_tfclinicatelefono ;
   private String AV79Clinicawwds_16_tfclinicatelefono_sel ;
   private String AV80Clinicawwds_17_tfclinicawhatsapp ;
   private String AV81Clinicawwds_18_tfclinicawhatsapp_sel ;
   private String scmdbuf ;
   private String lV78Clinicawwds_15_tfclinicatelefono ;
   private String lV80Clinicawwds_17_tfclinicawhatsapp ;
   private String A121ClinicaEstado ;
   private String A346ClinicaTelefono ;
   private String A347ClinicaWhatsApp ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk2T2 ;
   private boolean brk2T4 ;
   private boolean brk2T6 ;
   private boolean brk2T8 ;
   private boolean brk2T10 ;
   private boolean brk2T12 ;
   private boolean brk2T14 ;
   private boolean brk2T16 ;
   private boolean brk2T18 ;
   private boolean brk2T20 ;
   private String AV47OptionsJson ;
   private String AV50OptionsDescJson ;
   private String AV52OptionIndexesJson ;
   private String AV23TFClinicaMoneda_SelsJson ;
   private String AV37TFClinicaTiempoDeCita_SelsJson ;
   private String AV39TFClinicaEstado_SelsJson ;
   private String AV43DDOName ;
   private String AV41SearchTxt ;
   private String AV42SearchTxtTo ;
   private String AV59FilterFullText ;
   private String AV15TFClinicaNombreComercial ;
   private String AV16TFClinicaNombreComercial_Sel ;
   private String AV17TFClinicaNombreAbreviado ;
   private String AV18TFClinicaNombreAbreviado_Sel ;
   private String AV19TFClinicaDireccionComercial ;
   private String AV20TFClinicaDireccionComercial_Sel ;
   private String AV21TFClinicaCorreo ;
   private String AV22TFClinicaCorreo_Sel ;
   private String AV29TFClinicaFacebook ;
   private String AV30TFClinicaFacebook_Sel ;
   private String AV31TFClinicaTwiter ;
   private String AV32TFClinicaTwiter_Sel ;
   private String AV33TFClinicaInstagram ;
   private String AV34TFClinicaInstagram_Sel ;
   private String AV35TFClinicaLinkedin ;
   private String AV36TFClinicaLinkedin_Sel ;
   private String A116ClinicaNombreComercial ;
   private String AV64Clinicawwds_1_filterfulltext ;
   private String AV69Clinicawwds_6_tfclinicanombrecomercial ;
   private String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ;
   private String AV71Clinicawwds_8_tfclinicanombreabreviado ;
   private String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ;
   private String AV73Clinicawwds_10_tfclinicadireccioncomercial ;
   private String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ;
   private String AV75Clinicawwds_12_tfclinicacorreo ;
   private String AV76Clinicawwds_13_tfclinicacorreo_sel ;
   private String AV82Clinicawwds_19_tfclinicafacebook ;
   private String AV83Clinicawwds_20_tfclinicafacebook_sel ;
   private String AV84Clinicawwds_21_tfclinicatwiter ;
   private String AV85Clinicawwds_22_tfclinicatwiter_sel ;
   private String AV86Clinicawwds_23_tfclinicainstagram ;
   private String AV87Clinicawwds_24_tfclinicainstagram_sel ;
   private String AV88Clinicawwds_25_tfclinicalinkedin ;
   private String AV89Clinicawwds_26_tfclinicalinkedin_sel ;
   private String lV64Clinicawwds_1_filterfulltext ;
   private String lV69Clinicawwds_6_tfclinicanombrecomercial ;
   private String lV71Clinicawwds_8_tfclinicanombreabreviado ;
   private String lV73Clinicawwds_10_tfclinicadireccioncomercial ;
   private String lV75Clinicawwds_12_tfclinicacorreo ;
   private String lV82Clinicawwds_19_tfclinicafacebook ;
   private String lV84Clinicawwds_21_tfclinicatwiter ;
   private String lV86Clinicawwds_23_tfclinicainstagram ;
   private String lV88Clinicawwds_25_tfclinicalinkedin ;
   private String A80ClinicaNombreAbreviado ;
   private String A119ClinicaDireccionComercial ;
   private String A340ClinicaCorreo ;
   private String A348ClinicaFacebook ;
   private String A349ClinicaTwiter ;
   private String A350ClinicaInstagram ;
   private String A351ClinicaLinkedin ;
   private String AV45Option ;
   private GXSimpleCollection<Byte> AV38TFClinicaTiempoDeCita_Sels ;
   private GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ;
   private GXSimpleCollection<Short> AV24TFClinicaMoneda_Sels ;
   private GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ;
   private com.genexus.webpanels.WebSession AV54Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P002T2_A116ClinicaNombreComercial ;
   private long[] P002T2_A118ClinicaRUC ;
   private short[] P002T2_A28ClinicaId ;
   private String[] P002T2_A121ClinicaEstado ;
   private byte[] P002T2_A120ClinicaTiempoDeCita ;
   private String[] P002T2_A351ClinicaLinkedin ;
   private String[] P002T2_A350ClinicaInstagram ;
   private String[] P002T2_A349ClinicaTwiter ;
   private String[] P002T2_A348ClinicaFacebook ;
   private String[] P002T2_A347ClinicaWhatsApp ;
   private String[] P002T2_A346ClinicaTelefono ;
   private short[] P002T2_A341ClinicaMoneda ;
   private String[] P002T2_A340ClinicaCorreo ;
   private String[] P002T2_A119ClinicaDireccionComercial ;
   private String[] P002T2_A80ClinicaNombreAbreviado ;
   private String[] P002T3_A80ClinicaNombreAbreviado ;
   private long[] P002T3_A118ClinicaRUC ;
   private short[] P002T3_A28ClinicaId ;
   private String[] P002T3_A121ClinicaEstado ;
   private byte[] P002T3_A120ClinicaTiempoDeCita ;
   private String[] P002T3_A351ClinicaLinkedin ;
   private String[] P002T3_A350ClinicaInstagram ;
   private String[] P002T3_A349ClinicaTwiter ;
   private String[] P002T3_A348ClinicaFacebook ;
   private String[] P002T3_A347ClinicaWhatsApp ;
   private String[] P002T3_A346ClinicaTelefono ;
   private short[] P002T3_A341ClinicaMoneda ;
   private String[] P002T3_A340ClinicaCorreo ;
   private String[] P002T3_A119ClinicaDireccionComercial ;
   private String[] P002T3_A116ClinicaNombreComercial ;
   private String[] P002T4_A119ClinicaDireccionComercial ;
   private long[] P002T4_A118ClinicaRUC ;
   private short[] P002T4_A28ClinicaId ;
   private String[] P002T4_A121ClinicaEstado ;
   private byte[] P002T4_A120ClinicaTiempoDeCita ;
   private String[] P002T4_A351ClinicaLinkedin ;
   private String[] P002T4_A350ClinicaInstagram ;
   private String[] P002T4_A349ClinicaTwiter ;
   private String[] P002T4_A348ClinicaFacebook ;
   private String[] P002T4_A347ClinicaWhatsApp ;
   private String[] P002T4_A346ClinicaTelefono ;
   private short[] P002T4_A341ClinicaMoneda ;
   private String[] P002T4_A340ClinicaCorreo ;
   private String[] P002T4_A80ClinicaNombreAbreviado ;
   private String[] P002T4_A116ClinicaNombreComercial ;
   private String[] P002T5_A340ClinicaCorreo ;
   private long[] P002T5_A118ClinicaRUC ;
   private short[] P002T5_A28ClinicaId ;
   private String[] P002T5_A121ClinicaEstado ;
   private byte[] P002T5_A120ClinicaTiempoDeCita ;
   private String[] P002T5_A351ClinicaLinkedin ;
   private String[] P002T5_A350ClinicaInstagram ;
   private String[] P002T5_A349ClinicaTwiter ;
   private String[] P002T5_A348ClinicaFacebook ;
   private String[] P002T5_A347ClinicaWhatsApp ;
   private String[] P002T5_A346ClinicaTelefono ;
   private short[] P002T5_A341ClinicaMoneda ;
   private String[] P002T5_A119ClinicaDireccionComercial ;
   private String[] P002T5_A80ClinicaNombreAbreviado ;
   private String[] P002T5_A116ClinicaNombreComercial ;
   private String[] P002T6_A346ClinicaTelefono ;
   private long[] P002T6_A118ClinicaRUC ;
   private short[] P002T6_A28ClinicaId ;
   private String[] P002T6_A121ClinicaEstado ;
   private byte[] P002T6_A120ClinicaTiempoDeCita ;
   private String[] P002T6_A351ClinicaLinkedin ;
   private String[] P002T6_A350ClinicaInstagram ;
   private String[] P002T6_A349ClinicaTwiter ;
   private String[] P002T6_A348ClinicaFacebook ;
   private String[] P002T6_A347ClinicaWhatsApp ;
   private short[] P002T6_A341ClinicaMoneda ;
   private String[] P002T6_A340ClinicaCorreo ;
   private String[] P002T6_A119ClinicaDireccionComercial ;
   private String[] P002T6_A80ClinicaNombreAbreviado ;
   private String[] P002T6_A116ClinicaNombreComercial ;
   private String[] P002T7_A347ClinicaWhatsApp ;
   private long[] P002T7_A118ClinicaRUC ;
   private short[] P002T7_A28ClinicaId ;
   private String[] P002T7_A121ClinicaEstado ;
   private byte[] P002T7_A120ClinicaTiempoDeCita ;
   private String[] P002T7_A351ClinicaLinkedin ;
   private String[] P002T7_A350ClinicaInstagram ;
   private String[] P002T7_A349ClinicaTwiter ;
   private String[] P002T7_A348ClinicaFacebook ;
   private String[] P002T7_A346ClinicaTelefono ;
   private short[] P002T7_A341ClinicaMoneda ;
   private String[] P002T7_A340ClinicaCorreo ;
   private String[] P002T7_A119ClinicaDireccionComercial ;
   private String[] P002T7_A80ClinicaNombreAbreviado ;
   private String[] P002T7_A116ClinicaNombreComercial ;
   private String[] P002T8_A348ClinicaFacebook ;
   private long[] P002T8_A118ClinicaRUC ;
   private short[] P002T8_A28ClinicaId ;
   private String[] P002T8_A121ClinicaEstado ;
   private byte[] P002T8_A120ClinicaTiempoDeCita ;
   private String[] P002T8_A351ClinicaLinkedin ;
   private String[] P002T8_A350ClinicaInstagram ;
   private String[] P002T8_A349ClinicaTwiter ;
   private String[] P002T8_A347ClinicaWhatsApp ;
   private String[] P002T8_A346ClinicaTelefono ;
   private short[] P002T8_A341ClinicaMoneda ;
   private String[] P002T8_A340ClinicaCorreo ;
   private String[] P002T8_A119ClinicaDireccionComercial ;
   private String[] P002T8_A80ClinicaNombreAbreviado ;
   private String[] P002T8_A116ClinicaNombreComercial ;
   private String[] P002T9_A349ClinicaTwiter ;
   private long[] P002T9_A118ClinicaRUC ;
   private short[] P002T9_A28ClinicaId ;
   private String[] P002T9_A121ClinicaEstado ;
   private byte[] P002T9_A120ClinicaTiempoDeCita ;
   private String[] P002T9_A351ClinicaLinkedin ;
   private String[] P002T9_A350ClinicaInstagram ;
   private String[] P002T9_A348ClinicaFacebook ;
   private String[] P002T9_A347ClinicaWhatsApp ;
   private String[] P002T9_A346ClinicaTelefono ;
   private short[] P002T9_A341ClinicaMoneda ;
   private String[] P002T9_A340ClinicaCorreo ;
   private String[] P002T9_A119ClinicaDireccionComercial ;
   private String[] P002T9_A80ClinicaNombreAbreviado ;
   private String[] P002T9_A116ClinicaNombreComercial ;
   private String[] P002T10_A350ClinicaInstagram ;
   private long[] P002T10_A118ClinicaRUC ;
   private short[] P002T10_A28ClinicaId ;
   private String[] P002T10_A121ClinicaEstado ;
   private byte[] P002T10_A120ClinicaTiempoDeCita ;
   private String[] P002T10_A351ClinicaLinkedin ;
   private String[] P002T10_A349ClinicaTwiter ;
   private String[] P002T10_A348ClinicaFacebook ;
   private String[] P002T10_A347ClinicaWhatsApp ;
   private String[] P002T10_A346ClinicaTelefono ;
   private short[] P002T10_A341ClinicaMoneda ;
   private String[] P002T10_A340ClinicaCorreo ;
   private String[] P002T10_A119ClinicaDireccionComercial ;
   private String[] P002T10_A80ClinicaNombreAbreviado ;
   private String[] P002T10_A116ClinicaNombreComercial ;
   private String[] P002T11_A351ClinicaLinkedin ;
   private long[] P002T11_A118ClinicaRUC ;
   private short[] P002T11_A28ClinicaId ;
   private String[] P002T11_A121ClinicaEstado ;
   private byte[] P002T11_A120ClinicaTiempoDeCita ;
   private String[] P002T11_A350ClinicaInstagram ;
   private String[] P002T11_A349ClinicaTwiter ;
   private String[] P002T11_A348ClinicaFacebook ;
   private String[] P002T11_A347ClinicaWhatsApp ;
   private String[] P002T11_A346ClinicaTelefono ;
   private short[] P002T11_A341ClinicaMoneda ;
   private String[] P002T11_A340ClinicaCorreo ;
   private String[] P002T11_A119ClinicaDireccionComercial ;
   private String[] P002T11_A80ClinicaNombreAbreviado ;
   private String[] P002T11_A116ClinicaNombreComercial ;
   private GXSimpleCollection<String> AV40TFClinicaEstado_Sels ;
   private GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ;
   private GXSimpleCollection<String> AV46Options ;
   private GXSimpleCollection<String> AV49OptionsDesc ;
   private GXSimpleCollection<String> AV51OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV56GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV57GridStateFilterValue ;
}

final  class clinicawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002T2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV64Clinicawwds_1_filterfulltext ,
                                          short AV65Clinicawwds_2_tfclinicaid ,
                                          short AV66Clinicawwds_3_tfclinicaid_to ,
                                          long AV67Clinicawwds_4_tfclinicaruc ,
                                          long AV68Clinicawwds_5_tfclinicaruc_to ,
                                          String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV75Clinicawwds_12_tfclinicacorreo ,
                                          int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV78Clinicawwds_15_tfclinicatelefono ,
                                          String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV82Clinicawwds_19_tfclinicafacebook ,
                                          String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV84Clinicawwds_21_tfclinicatwiter ,
                                          String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV86Clinicawwds_23_tfclinicainstagram ,
                                          String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV88Clinicawwds_25_tfclinicalinkedin ,
                                          int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[43];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [ClinicaNombreComercial], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook]," ;
      scmdbuf += " [ClinicaWhatsApp], [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
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
         GXv_int4[8] = (byte)(1) ;
         GXv_int4[9] = (byte)(1) ;
         GXv_int4[10] = (byte)(1) ;
         GXv_int4[11] = (byte)(1) ;
         GXv_int4[12] = (byte)(1) ;
         GXv_int4[13] = (byte)(1) ;
         GXv_int4[14] = (byte)(1) ;
         GXv_int4[15] = (byte)(1) ;
         GXv_int4[16] = (byte)(1) ;
         GXv_int4[17] = (byte)(1) ;
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaNombreComercial]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002T3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV64Clinicawwds_1_filterfulltext ,
                                          short AV65Clinicawwds_2_tfclinicaid ,
                                          short AV66Clinicawwds_3_tfclinicaid_to ,
                                          long AV67Clinicawwds_4_tfclinicaruc ,
                                          long AV68Clinicawwds_5_tfclinicaruc_to ,
                                          String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV75Clinicawwds_12_tfclinicacorreo ,
                                          int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV78Clinicawwds_15_tfclinicatelefono ,
                                          String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV82Clinicawwds_19_tfclinicafacebook ,
                                          String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV84Clinicawwds_21_tfclinicatwiter ,
                                          String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV86Clinicawwds_23_tfclinicainstagram ,
                                          String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV88Clinicawwds_25_tfclinicalinkedin ,
                                          int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[43];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [ClinicaNombreAbreviado], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook]," ;
      scmdbuf += " [ClinicaWhatsApp], [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
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
         GXv_int7[8] = (byte)(1) ;
         GXv_int7[9] = (byte)(1) ;
         GXv_int7[10] = (byte)(1) ;
         GXv_int7[11] = (byte)(1) ;
         GXv_int7[12] = (byte)(1) ;
         GXv_int7[13] = (byte)(1) ;
         GXv_int7[14] = (byte)(1) ;
         GXv_int7[15] = (byte)(1) ;
         GXv_int7[16] = (byte)(1) ;
         GXv_int7[17] = (byte)(1) ;
         GXv_int7[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int7[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int7[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int7[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int7[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int7[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int7[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int7[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int7[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int7[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int7[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int7[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int7[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int7[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int7[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int7[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int7[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int7[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int7[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int7[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int7[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int7[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int7[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int7[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int7[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaNombreAbreviado]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P002T4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV64Clinicawwds_1_filterfulltext ,
                                          short AV65Clinicawwds_2_tfclinicaid ,
                                          short AV66Clinicawwds_3_tfclinicaid_to ,
                                          long AV67Clinicawwds_4_tfclinicaruc ,
                                          long AV68Clinicawwds_5_tfclinicaruc_to ,
                                          String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV75Clinicawwds_12_tfclinicacorreo ,
                                          int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV78Clinicawwds_15_tfclinicatelefono ,
                                          String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV82Clinicawwds_19_tfclinicafacebook ,
                                          String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV84Clinicawwds_21_tfclinicatwiter ,
                                          String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV86Clinicawwds_23_tfclinicainstagram ,
                                          String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV88Clinicawwds_25_tfclinicalinkedin ,
                                          int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[43];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [ClinicaDireccionComercial], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook]," ;
      scmdbuf += " [ClinicaWhatsApp], [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
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
         GXv_int10[8] = (byte)(1) ;
         GXv_int10[9] = (byte)(1) ;
         GXv_int10[10] = (byte)(1) ;
         GXv_int10[11] = (byte)(1) ;
         GXv_int10[12] = (byte)(1) ;
         GXv_int10[13] = (byte)(1) ;
         GXv_int10[14] = (byte)(1) ;
         GXv_int10[15] = (byte)(1) ;
         GXv_int10[16] = (byte)(1) ;
         GXv_int10[17] = (byte)(1) ;
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int10[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int10[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int10[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int10[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int10[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int10[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int10[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int10[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int10[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int10[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int10[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int10[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int10[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaDireccionComercial]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P002T5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV64Clinicawwds_1_filterfulltext ,
                                          short AV65Clinicawwds_2_tfclinicaid ,
                                          short AV66Clinicawwds_3_tfclinicaid_to ,
                                          long AV67Clinicawwds_4_tfclinicaruc ,
                                          long AV68Clinicawwds_5_tfclinicaruc_to ,
                                          String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV75Clinicawwds_12_tfclinicacorreo ,
                                          int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV78Clinicawwds_15_tfclinicatelefono ,
                                          String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV82Clinicawwds_19_tfclinicafacebook ,
                                          String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV84Clinicawwds_21_tfclinicatwiter ,
                                          String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV86Clinicawwds_23_tfclinicainstagram ,
                                          String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV88Clinicawwds_25_tfclinicalinkedin ,
                                          int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[43];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT [ClinicaCorreo], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook]," ;
      scmdbuf += " [ClinicaWhatsApp], [ClinicaTelefono], [ClinicaMoneda], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int13[0] = (byte)(1) ;
         GXv_int13[1] = (byte)(1) ;
         GXv_int13[2] = (byte)(1) ;
         GXv_int13[3] = (byte)(1) ;
         GXv_int13[4] = (byte)(1) ;
         GXv_int13[5] = (byte)(1) ;
         GXv_int13[6] = (byte)(1) ;
         GXv_int13[7] = (byte)(1) ;
         GXv_int13[8] = (byte)(1) ;
         GXv_int13[9] = (byte)(1) ;
         GXv_int13[10] = (byte)(1) ;
         GXv_int13[11] = (byte)(1) ;
         GXv_int13[12] = (byte)(1) ;
         GXv_int13[13] = (byte)(1) ;
         GXv_int13[14] = (byte)(1) ;
         GXv_int13[15] = (byte)(1) ;
         GXv_int13[16] = (byte)(1) ;
         GXv_int13[17] = (byte)(1) ;
         GXv_int13[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int13[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int13[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int13[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int13[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int13[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int13[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int13[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int13[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int13[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int13[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int13[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int13[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int13[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int13[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int13[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int13[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int13[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int13[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int13[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int13[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int13[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int13[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int13[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int13[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaCorreo]" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P002T6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV64Clinicawwds_1_filterfulltext ,
                                          short AV65Clinicawwds_2_tfclinicaid ,
                                          short AV66Clinicawwds_3_tfclinicaid_to ,
                                          long AV67Clinicawwds_4_tfclinicaruc ,
                                          long AV68Clinicawwds_5_tfclinicaruc_to ,
                                          String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV75Clinicawwds_12_tfclinicacorreo ,
                                          int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV78Clinicawwds_15_tfclinicatelefono ,
                                          String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV82Clinicawwds_19_tfclinicafacebook ,
                                          String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV84Clinicawwds_21_tfclinicatwiter ,
                                          String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV86Clinicawwds_23_tfclinicainstagram ,
                                          String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV88Clinicawwds_25_tfclinicalinkedin ,
                                          int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[43];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT [ClinicaTelefono], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook]," ;
      scmdbuf += " [ClinicaWhatsApp], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int16[0] = (byte)(1) ;
         GXv_int16[1] = (byte)(1) ;
         GXv_int16[2] = (byte)(1) ;
         GXv_int16[3] = (byte)(1) ;
         GXv_int16[4] = (byte)(1) ;
         GXv_int16[5] = (byte)(1) ;
         GXv_int16[6] = (byte)(1) ;
         GXv_int16[7] = (byte)(1) ;
         GXv_int16[8] = (byte)(1) ;
         GXv_int16[9] = (byte)(1) ;
         GXv_int16[10] = (byte)(1) ;
         GXv_int16[11] = (byte)(1) ;
         GXv_int16[12] = (byte)(1) ;
         GXv_int16[13] = (byte)(1) ;
         GXv_int16[14] = (byte)(1) ;
         GXv_int16[15] = (byte)(1) ;
         GXv_int16[16] = (byte)(1) ;
         GXv_int16[17] = (byte)(1) ;
         GXv_int16[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int16[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int16[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int16[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int16[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int16[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int16[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int16[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int16[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int16[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int16[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int16[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int16[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int16[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int16[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int16[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int16[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int16[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int16[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int16[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int16[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int16[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int16[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int16[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int16[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaTelefono]" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P002T7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV64Clinicawwds_1_filterfulltext ,
                                          short AV65Clinicawwds_2_tfclinicaid ,
                                          short AV66Clinicawwds_3_tfclinicaid_to ,
                                          long AV67Clinicawwds_4_tfclinicaruc ,
                                          long AV68Clinicawwds_5_tfclinicaruc_to ,
                                          String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV75Clinicawwds_12_tfclinicacorreo ,
                                          int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV78Clinicawwds_15_tfclinicatelefono ,
                                          String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV82Clinicawwds_19_tfclinicafacebook ,
                                          String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV84Clinicawwds_21_tfclinicatwiter ,
                                          String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV86Clinicawwds_23_tfclinicainstagram ,
                                          String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV88Clinicawwds_25_tfclinicalinkedin ,
                                          int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[43];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT [ClinicaWhatsApp], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook]," ;
      scmdbuf += " [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int19[0] = (byte)(1) ;
         GXv_int19[1] = (byte)(1) ;
         GXv_int19[2] = (byte)(1) ;
         GXv_int19[3] = (byte)(1) ;
         GXv_int19[4] = (byte)(1) ;
         GXv_int19[5] = (byte)(1) ;
         GXv_int19[6] = (byte)(1) ;
         GXv_int19[7] = (byte)(1) ;
         GXv_int19[8] = (byte)(1) ;
         GXv_int19[9] = (byte)(1) ;
         GXv_int19[10] = (byte)(1) ;
         GXv_int19[11] = (byte)(1) ;
         GXv_int19[12] = (byte)(1) ;
         GXv_int19[13] = (byte)(1) ;
         GXv_int19[14] = (byte)(1) ;
         GXv_int19[15] = (byte)(1) ;
         GXv_int19[16] = (byte)(1) ;
         GXv_int19[17] = (byte)(1) ;
         GXv_int19[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int19[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int19[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int19[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int19[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int19[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int19[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int19[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int19[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int19[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int19[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int19[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int19[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int19[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int19[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int19[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int19[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int19[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int19[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int19[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int19[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int19[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int19[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int19[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int19[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaWhatsApp]" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P002T8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV64Clinicawwds_1_filterfulltext ,
                                          short AV65Clinicawwds_2_tfclinicaid ,
                                          short AV66Clinicawwds_3_tfclinicaid_to ,
                                          long AV67Clinicawwds_4_tfclinicaruc ,
                                          long AV68Clinicawwds_5_tfclinicaruc_to ,
                                          String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV75Clinicawwds_12_tfclinicacorreo ,
                                          int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV78Clinicawwds_15_tfclinicatelefono ,
                                          String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV82Clinicawwds_19_tfclinicafacebook ,
                                          String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV84Clinicawwds_21_tfclinicatwiter ,
                                          String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV86Clinicawwds_23_tfclinicainstagram ,
                                          String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV88Clinicawwds_25_tfclinicalinkedin ,
                                          int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[43];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT [ClinicaFacebook], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaWhatsApp]," ;
      scmdbuf += " [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
         GXv_int22[1] = (byte)(1) ;
         GXv_int22[2] = (byte)(1) ;
         GXv_int22[3] = (byte)(1) ;
         GXv_int22[4] = (byte)(1) ;
         GXv_int22[5] = (byte)(1) ;
         GXv_int22[6] = (byte)(1) ;
         GXv_int22[7] = (byte)(1) ;
         GXv_int22[8] = (byte)(1) ;
         GXv_int22[9] = (byte)(1) ;
         GXv_int22[10] = (byte)(1) ;
         GXv_int22[11] = (byte)(1) ;
         GXv_int22[12] = (byte)(1) ;
         GXv_int22[13] = (byte)(1) ;
         GXv_int22[14] = (byte)(1) ;
         GXv_int22[15] = (byte)(1) ;
         GXv_int22[16] = (byte)(1) ;
         GXv_int22[17] = (byte)(1) ;
         GXv_int22[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int22[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int22[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int22[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int22[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int22[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int22[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int22[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int22[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int22[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int22[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int22[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int22[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int22[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int22[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int22[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int22[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int22[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int22[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int22[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int22[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int22[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int22[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int22[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int22[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaFacebook]" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_P002T9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV64Clinicawwds_1_filterfulltext ,
                                          short AV65Clinicawwds_2_tfclinicaid ,
                                          short AV66Clinicawwds_3_tfclinicaid_to ,
                                          long AV67Clinicawwds_4_tfclinicaruc ,
                                          long AV68Clinicawwds_5_tfclinicaruc_to ,
                                          String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV75Clinicawwds_12_tfclinicacorreo ,
                                          int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV78Clinicawwds_15_tfclinicatelefono ,
                                          String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV82Clinicawwds_19_tfclinicafacebook ,
                                          String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV84Clinicawwds_21_tfclinicatwiter ,
                                          String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV86Clinicawwds_23_tfclinicainstagram ,
                                          String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV88Clinicawwds_25_tfclinicalinkedin ,
                                          int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[43];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT [ClinicaTwiter], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaFacebook], [ClinicaWhatsApp]," ;
      scmdbuf += " [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int25[0] = (byte)(1) ;
         GXv_int25[1] = (byte)(1) ;
         GXv_int25[2] = (byte)(1) ;
         GXv_int25[3] = (byte)(1) ;
         GXv_int25[4] = (byte)(1) ;
         GXv_int25[5] = (byte)(1) ;
         GXv_int25[6] = (byte)(1) ;
         GXv_int25[7] = (byte)(1) ;
         GXv_int25[8] = (byte)(1) ;
         GXv_int25[9] = (byte)(1) ;
         GXv_int25[10] = (byte)(1) ;
         GXv_int25[11] = (byte)(1) ;
         GXv_int25[12] = (byte)(1) ;
         GXv_int25[13] = (byte)(1) ;
         GXv_int25[14] = (byte)(1) ;
         GXv_int25[15] = (byte)(1) ;
         GXv_int25[16] = (byte)(1) ;
         GXv_int25[17] = (byte)(1) ;
         GXv_int25[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int25[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int25[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int25[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int25[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int25[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int25[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int25[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int25[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int25[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int25[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int25[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int25[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int25[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int25[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int25[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int25[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int25[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int25[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int25[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int25[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int25[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int25[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int25[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int25[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaTwiter]" ;
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
   }

   protected Object[] conditional_P002T10( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           short A341ClinicaMoneda ,
                                           GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           byte A120ClinicaTiempoDeCita ,
                                           GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           String A121ClinicaEstado ,
                                           GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           String AV64Clinicawwds_1_filterfulltext ,
                                           short AV65Clinicawwds_2_tfclinicaid ,
                                           short AV66Clinicawwds_3_tfclinicaid_to ,
                                           long AV67Clinicawwds_4_tfclinicaruc ,
                                           long AV68Clinicawwds_5_tfclinicaruc_to ,
                                           String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           String AV75Clinicawwds_12_tfclinicacorreo ,
                                           int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                           String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           String AV78Clinicawwds_15_tfclinicatelefono ,
                                           String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           String AV82Clinicawwds_19_tfclinicafacebook ,
                                           String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           String AV84Clinicawwds_21_tfclinicatwiter ,
                                           String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           String AV86Clinicawwds_23_tfclinicainstagram ,
                                           String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           String AV88Clinicawwds_25_tfclinicalinkedin ,
                                           int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                           int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                           short A28ClinicaId ,
                                           long A118ClinicaRUC ,
                                           String A116ClinicaNombreComercial ,
                                           String A80ClinicaNombreAbreviado ,
                                           String A119ClinicaDireccionComercial ,
                                           String A340ClinicaCorreo ,
                                           String A346ClinicaTelefono ,
                                           String A347ClinicaWhatsApp ,
                                           String A348ClinicaFacebook ,
                                           String A349ClinicaTwiter ,
                                           String A350ClinicaInstagram ,
                                           String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int28 = new byte[43];
      Object[] GXv_Object29 = new Object[2];
      scmdbuf = "SELECT [ClinicaInstagram], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaTwiter], [ClinicaFacebook], [ClinicaWhatsApp]," ;
      scmdbuf += " [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int28[0] = (byte)(1) ;
         GXv_int28[1] = (byte)(1) ;
         GXv_int28[2] = (byte)(1) ;
         GXv_int28[3] = (byte)(1) ;
         GXv_int28[4] = (byte)(1) ;
         GXv_int28[5] = (byte)(1) ;
         GXv_int28[6] = (byte)(1) ;
         GXv_int28[7] = (byte)(1) ;
         GXv_int28[8] = (byte)(1) ;
         GXv_int28[9] = (byte)(1) ;
         GXv_int28[10] = (byte)(1) ;
         GXv_int28[11] = (byte)(1) ;
         GXv_int28[12] = (byte)(1) ;
         GXv_int28[13] = (byte)(1) ;
         GXv_int28[14] = (byte)(1) ;
         GXv_int28[15] = (byte)(1) ;
         GXv_int28[16] = (byte)(1) ;
         GXv_int28[17] = (byte)(1) ;
         GXv_int28[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int28[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int28[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int28[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int28[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int28[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int28[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int28[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int28[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int28[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int28[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int28[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int28[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int28[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int28[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int28[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int28[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int28[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int28[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int28[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int28[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int28[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int28[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int28[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int28[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaInstagram]" ;
      GXv_Object29[0] = scmdbuf ;
      GXv_Object29[1] = GXv_int28 ;
      return GXv_Object29 ;
   }

   protected Object[] conditional_P002T11( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           short A341ClinicaMoneda ,
                                           GXSimpleCollection<Short> AV77Clinicawwds_14_tfclinicamoneda_sels ,
                                           byte A120ClinicaTiempoDeCita ,
                                           GXSimpleCollection<Byte> AV90Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           String A121ClinicaEstado ,
                                           GXSimpleCollection<String> AV91Clinicawwds_28_tfclinicaestado_sels ,
                                           String AV64Clinicawwds_1_filterfulltext ,
                                           short AV65Clinicawwds_2_tfclinicaid ,
                                           short AV66Clinicawwds_3_tfclinicaid_to ,
                                           long AV67Clinicawwds_4_tfclinicaruc ,
                                           long AV68Clinicawwds_5_tfclinicaruc_to ,
                                           String AV70Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           String AV69Clinicawwds_6_tfclinicanombrecomercial ,
                                           String AV72Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           String AV71Clinicawwds_8_tfclinicanombreabreviado ,
                                           String AV74Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           String AV73Clinicawwds_10_tfclinicadireccioncomercial ,
                                           String AV76Clinicawwds_13_tfclinicacorreo_sel ,
                                           String AV75Clinicawwds_12_tfclinicacorreo ,
                                           int AV77Clinicawwds_14_tfclinicamoneda_sels_size ,
                                           String AV79Clinicawwds_16_tfclinicatelefono_sel ,
                                           String AV78Clinicawwds_15_tfclinicatelefono ,
                                           String AV81Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           String AV80Clinicawwds_17_tfclinicawhatsapp ,
                                           String AV83Clinicawwds_20_tfclinicafacebook_sel ,
                                           String AV82Clinicawwds_19_tfclinicafacebook ,
                                           String AV85Clinicawwds_22_tfclinicatwiter_sel ,
                                           String AV84Clinicawwds_21_tfclinicatwiter ,
                                           String AV87Clinicawwds_24_tfclinicainstagram_sel ,
                                           String AV86Clinicawwds_23_tfclinicainstagram ,
                                           String AV89Clinicawwds_26_tfclinicalinkedin_sel ,
                                           String AV88Clinicawwds_25_tfclinicalinkedin ,
                                           int AV90Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                           int AV91Clinicawwds_28_tfclinicaestado_sels_size ,
                                           short A28ClinicaId ,
                                           long A118ClinicaRUC ,
                                           String A116ClinicaNombreComercial ,
                                           String A80ClinicaNombreAbreviado ,
                                           String A119ClinicaDireccionComercial ,
                                           String A340ClinicaCorreo ,
                                           String A346ClinicaTelefono ,
                                           String A347ClinicaWhatsApp ,
                                           String A348ClinicaFacebook ,
                                           String A349ClinicaTwiter ,
                                           String A350ClinicaInstagram ,
                                           String A351ClinicaLinkedin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int31 = new byte[43];
      Object[] GXv_Object32 = new Object[2];
      scmdbuf = "SELECT [ClinicaLinkedin], [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook], [ClinicaWhatsApp]," ;
      scmdbuf += " [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV64Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int31[0] = (byte)(1) ;
         GXv_int31[1] = (byte)(1) ;
         GXv_int31[2] = (byte)(1) ;
         GXv_int31[3] = (byte)(1) ;
         GXv_int31[4] = (byte)(1) ;
         GXv_int31[5] = (byte)(1) ;
         GXv_int31[6] = (byte)(1) ;
         GXv_int31[7] = (byte)(1) ;
         GXv_int31[8] = (byte)(1) ;
         GXv_int31[9] = (byte)(1) ;
         GXv_int31[10] = (byte)(1) ;
         GXv_int31[11] = (byte)(1) ;
         GXv_int31[12] = (byte)(1) ;
         GXv_int31[13] = (byte)(1) ;
         GXv_int31[14] = (byte)(1) ;
         GXv_int31[15] = (byte)(1) ;
         GXv_int31[16] = (byte)(1) ;
         GXv_int31[17] = (byte)(1) ;
         GXv_int31[18] = (byte)(1) ;
      }
      if ( ! (0==AV65Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int31[19] = (byte)(1) ;
      }
      if ( ! (0==AV66Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int31[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int31[21] = (byte)(1) ;
      }
      if ( ! (0==AV68Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int31[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV69Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int31[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int31[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV71Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int31[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int31[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int31[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int31[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int31[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int31[30] = (byte)(1) ;
      }
      if ( AV77Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV78Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int31[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int31[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV80Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int31[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int31[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int31[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int31[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int31[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int31[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int31[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int31[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int31[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int31[42] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV91Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaLinkedin]" ;
      GXv_Object32[0] = scmdbuf ;
      GXv_Object32[1] = GXv_int31 ;
      return GXv_Object32 ;
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
                  return conditional_P002T2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 1 :
                  return conditional_P002T3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 2 :
                  return conditional_P002T4(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 3 :
                  return conditional_P002T5(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 4 :
                  return conditional_P002T6(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 5 :
                  return conditional_P002T7(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 6 :
                  return conditional_P002T8(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 7 :
                  return conditional_P002T9(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 8 :
                  return conditional_P002T10(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
            case 9 :
                  return conditional_P002T11(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002T2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T10", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002T11", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 15);
               ((String[]) buf[10])[0] = rslt.getString(11, 12);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 15);
               ((String[]) buf[10])[0] = rslt.getString(11, 12);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 15);
               ((String[]) buf[10])[0] = rslt.getString(11, 12);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 15);
               ((String[]) buf[10])[0] = rslt.getString(11, 12);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 12);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 15);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 15);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 12);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 15);
               ((String[]) buf[9])[0] = rslt.getString(10, 12);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 15);
               ((String[]) buf[9])[0] = rslt.getString(10, 12);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 15);
               ((String[]) buf[9])[0] = rslt.getString(10, 12);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 15);
               ((String[]) buf[9])[0] = rslt.getString(10, 12);
               ((short[]) buf[10])[0] = rslt.getShort(11);
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
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 8 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
            case 9 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
      }
   }

}

