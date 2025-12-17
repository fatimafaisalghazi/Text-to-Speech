public class MessagesLocalization {

    private static String currentLang = "2";

    public static void setLanguage(String lang) throws InputException {
        if (lang.equals("1")) {
            currentLang = "1";
        } else if (lang.equals("2")) {
            currentLang = "2";
        } else {
            throw new InputException("Incorrect input! Please enter 1 or 2");
        }
    }

    public static String get(String key) {
        if ("1".equals(currentLang)) {
            return getArabic(key);
        }
        return getEnglish(key);
    }

    private static String getArabic(String key) {
        switch (key) {
            case "enter_sentence":
                return "أدخل جملة:";
            case "choose_language":
                return "أدخل 1 للعربية أو 2 للإنجليزية:";
            case "playing":
                return "🔊 يتم التشغيل: ";
            case "finished":
                return "✓ انتهى التشغيل";
            case "error_playing":
                return "خطأ في التشغيل: ";
            case "error_network":
                return "خطأ في الاتصال بالشبكة";
            case "error_no_internet":
                return "لا يوجد اتصال بالإنترنت! تحقق من الشبكة";
            case "error_connection":
                return "فشل الاتصال بالخادم";
            case "error_input":
                return "إدخال خاطئ! الرجاء إدخال 1 أو 2";
            case "empty_text":
                return "❌ النص فارغ!";
            default:
                return key;
        }
    }

    private static String getEnglish(String key) {
        switch (key) {
            case "enter_sentence":
                return "Enter a sentence:";
            case "choose_language":
                return "Enter 1 for Arabic or 2 for English:";
            case "playing":
                return "🔊 Playing: ";
            case "finished":
                return "✓ Playback finished";
            case "error_playing":
                return "Playback error: ";
            case "error_network":
                return "Network connection error";
            case "error_no_internet":
                return "No internet connection! Check your network";
            case "error_connection":
                return "Failed to connect to server";
            case "error_input":
                return "Incorrect input! Please enter 1 or 2";
            case "empty_text":
                return "❌ Text is empty!";
            default:
                return key;
        }
    }
}