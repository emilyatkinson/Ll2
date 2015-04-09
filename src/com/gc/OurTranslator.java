package com.gc;

import java.util.List;

import org.apache.commons.lang3.text.WordUtils;

import com.neovisionaries.i18n.LanguageCode;

public class OurTranslator {

	public static Holder translateSentences(Holder ourHolder) {

		String language = ourHolder.getLanguage();
		language = WordUtils.capitalize(language);
		String[] targets = ourHolder.getTargets();
		String[] translations = new String[targets.length];
		List<LanguageCode> code = LanguageCode.findByName(language);
		language = code.get(0).toString();

		for (int i = 0; i < targets.length; i++) {
			translations[i] = GoogleTranslate.googleTranslateApi(targets[i],
					"en", language);
		}

		ourHolder = new Holder(ourHolder, targets, translations);

		return ourHolder;
	}
}