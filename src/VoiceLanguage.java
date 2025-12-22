public class VoiceLanguage {

    private static final String ARABIC_VOICE = "Mehdi22k";
    private static final String ENGLISH_VOICE = "Heather22k";
    private static String lang;

    public static void setLang(String chose) throws InputException {
        MessagesLocalization.setLanguage(chose);

        if (chose.equals("1")) {
            lang = "ARABIC";
        } else if (chose.equals("2")) {
            lang = "ENGLISH";
        }
    }

    public static String getVoiceLang() {
        if ("ARABIC".equals(lang)) return ARABIC_VOICE;
        return ENGLISH_VOICE;
    }
}
