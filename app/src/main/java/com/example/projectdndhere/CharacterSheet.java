package com.example.projectdndhere;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CharacterSheet extends AppCompatActivity {

    private TextView mStrengthModifierEditText;
    private TextView mInitiative;
    private EditText mCharacterName;
    private EditText mCharacterBackground;
    private EditText mClass;
    private EditText mArmorClass;
    private EditText mPassivePerceptionEditText;
    private TextView mDexterityModifierEditText;
    private TextView mConstitutionModifierEditText;
    private TextView mIntelligenceModifierEditText;
    private TextView mWisdomModifierEditText;
    private TextView mCharismaModifierEditText;

    private CheckBox mStrengthProficiencyCheckBox;
    private CheckBox mDexterityProficiencyCheckBox;
    private CheckBox mConstitutionProficiencyCheckBox;
    private CheckBox mIntelligenceProficiencyCheckBox;
    private CheckBox mWisdomProficiencyCheckBox;
    private CheckBox mCharismaProficiencyCheckBox;

    private EditText mAcrobaticsModifierEditText;
    private CheckBox mAcrobaticsProficiencyCheckBox;

    private EditText mAnimalHandlingModifierEditText;
    private CheckBox mAnimalHandlingProficiencyCheckBox;

    private EditText mArcanaModifierEditText;
    private CheckBox mArcanaProficiencyCheckBox;

    private EditText mAthleticsModifierEditText;
    private CheckBox mAthleticsProficiencyCheckBox;

    private EditText mDeceptionModifierEditText;
    private CheckBox mDeceptionProficiencyCheckBox;

    private EditText mHistoryModifierEditText;
    private CheckBox mHistoryProficiencyCheckBox;

    private EditText mInsightModifierEditText;
    private CheckBox mInsightProficiencyCheckBox;

    private EditText mIntimidationModifierEditText;
    private CheckBox mIntimidationProficiencyCheckBox;

    private EditText mInvestigationModifierEditText;
    private CheckBox mInvestigationProficiencyCheckBox;

    private EditText mMedicineModifierEditText;
    private CheckBox mMedicineProficiencyCheckBox;

    private EditText mNatureModifierEditText;
    private CheckBox mNatureProficiencyCheckBox;

    private EditText mPerceptionModifierEditText;
    private CheckBox mPerceptionProficiencyCheckBox;

    private EditText mPerformanceModifierEditText;
    private CheckBox mPerformanceProficiencyCheckBox;

    private EditText mPersuasionModifierEditText;
    private CheckBox mPersuasionProficiencyCheckBox;

    private EditText mReligionModifierEditText;
    private CheckBox mReligionProficiencyCheckBox;

    private EditText mSleightOfHandModifierEditText;
    private CheckBox mSleightOfHandProficiencyCheckBox;

    private EditText mStealthModifierEditText;
    private CheckBox mStealthProficiencyCheckBox;

    private EditText mSurvivalModifierEditText;
    private CheckBox mSurvivalProficiencyCheckBox;

    private EditText mEquipmentEditText;
    private EditText mFeaturesAndTraitsEditText;
    private int proficiencyBonus;
    private EditText mLevelEditText;
    private EditText mStrengthScoreEditText;
    private EditText mDexterityScoreEditText;
    private EditText mConstitutionScoreEditText;
    private EditText mIntelligenceScoreEditText;
    private EditText mWisdomScoreEditText;
    private int level;
    private EditText mCharismaScoreEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by ID
        mStrengthScoreEditText = findViewById(R.id.strength_score);
        mConstitutionScoreEditText = findViewById(R.id.constitution_score);
        mIntelligenceScoreEditText = findViewById(R.id.intelligence_score);
        mWisdomScoreEditText = findViewById(R.id.wisdom_score);
        mCharismaScoreEditText = findViewById(R.id.charisma_score);
        mDexterityScoreEditText = findViewById(R.id.dexterity_score);
        mStrengthModifierEditText = findViewById(R.id.strength_modifier);
        mDexterityModifierEditText = findViewById(R.id.dexterity_modifier);
        mConstitutionModifierEditText = findViewById(R.id.constitution_modifier);
        mIntelligenceModifierEditText = findViewById(R.id.intelligence_modifier);
        mWisdomModifierEditText = findViewById(R.id.wisdom_modifier);
        mCharismaModifierEditText = findViewById(R.id.charisma_modifier);


        mCharacterName = findViewById(R.id.character_name);
        mCharacterBackground = findViewById(R.id.background);
        mClass = findViewById(R.id.character_class);
        mLevelEditText = findViewById(R.id.level);
        mInitiative = findViewById(R.id.initiative);

        mAcrobaticsModifierEditText = findViewById(R.id.acrobatics_modifier);
        mAcrobaticsProficiencyCheckBox = findViewById(R.id.acrobatics_proficiency);
        mAnimalHandlingModifierEditText = findViewById(R.id.animal_handling_modifier);
        mAnimalHandlingProficiencyCheckBox = findViewById(R.id.animal_handling_proficiency);

        mArcanaModifierEditText = findViewById(R.id.arcana_modifier);
        mArcanaProficiencyCheckBox = findViewById(R.id.arcana_proficiency);

        mAthleticsModifierEditText = findViewById(R.id.athletics_modifier);
        mAthleticsProficiencyCheckBox = findViewById(R.id.athletics_proficiency);

        mDeceptionModifierEditText = findViewById(R.id.deception_modifier);
        mDeceptionProficiencyCheckBox = findViewById(R.id.deception_proficiency);

        mHistoryModifierEditText = findViewById(R.id.history_modifier);
        mHistoryProficiencyCheckBox = findViewById(R.id.history_proficiency);

        mInsightModifierEditText = findViewById(R.id.insight_modifier);
        mInsightProficiencyCheckBox = findViewById(R.id.insight_proficiency);

        mIntimidationModifierEditText = findViewById(R.id.intimidation_modifier);
        mIntimidationProficiencyCheckBox = findViewById(R.id.intimidation_proficiency);

        mInvestigationModifierEditText = findViewById(R.id.investigation_modifier);
        mInvestigationProficiencyCheckBox = findViewById(R.id.investigation_proficiency);

        mMedicineModifierEditText = findViewById(R.id.medicine_modifier);
        mMedicineProficiencyCheckBox = findViewById(R.id.medicine_proficiency);

        mNatureModifierEditText = findViewById(R.id.nature_modifier);
        mNatureProficiencyCheckBox = findViewById(R.id.nature_proficiency);

        mPerceptionModifierEditText = findViewById(R.id.perception_modifier);
        mPerceptionProficiencyCheckBox = findViewById(R.id.perception_proficiency);

        mPerformanceModifierEditText = findViewById(R.id.performance_modifier);
        mPerformanceProficiencyCheckBox = findViewById(R.id.performance_proficiency);

        mPersuasionModifierEditText = findViewById(R.id.persuasion_modifier);
        mPersuasionProficiencyCheckBox = findViewById(R.id.persuasion_proficiency);

        mReligionModifierEditText = findViewById(R.id.religion_modifier);
        mReligionProficiencyCheckBox = findViewById(R.id.religion_proficiency);

        mSleightOfHandModifierEditText = findViewById(R.id.sleight_of_hand_modifier);
        mSleightOfHandProficiencyCheckBox = findViewById(R.id.sleight_of_hand_proficiency);

        mStealthModifierEditText = findViewById(R.id.stealth_modifier);
        mStealthProficiencyCheckBox = findViewById(R.id.stealth_proficiency);

        mSurvivalModifierEditText = findViewById(R.id.survival_modifier);
        mSurvivalProficiencyCheckBox = findViewById(R.id.survival_proficiency);

        mEquipmentEditText = findViewById(R.id.equipment_text);
        mFeaturesAndTraitsEditText = findViewById(R.id.features_and_traits_text);

        mPassivePerceptionEditText = findViewById(R.id.passive_perception);
        mArmorClass = findViewById(R.id.armor_class);
        mAcrobaticsProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mAnimalHandlingProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mArcanaProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mAthleticsProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mDeceptionProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mHistoryProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mInsightProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mIntimidationProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mInvestigationProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mMedicineProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mNatureProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mPerceptionProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mPerformanceProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mPersuasionProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mReligionProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mSleightOfHandProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mStealthProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });
        mSurvivalProficiencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleProficiency(buttonView);
            }
        });

        mStrengthScoreEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    int score = Integer.parseInt(s.toString());
                    int modifier = calculateAbilityModifier(score);
                    mStrengthModifierEditText.setText(String.valueOf(modifier));
                    mAthleticsModifierEditText.setText(String.valueOf(modifier));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        mDexterityScoreEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    int score = Integer.parseInt(s.toString());
                    int modifier = calculateAbilityModifier(score);
                    mDexterityModifierEditText.setText(String.valueOf(modifier));
                    mAcrobaticsModifierEditText.setText(String.valueOf(modifier));
                    mStealthModifierEditText.setText(String.valueOf(modifier));
                    mSleightOfHandModifierEditText.setText(String.valueOf(modifier));
                    mInitiative.setText(String.valueOf(modifier));


                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        mConstitutionScoreEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    int score = Integer.parseInt(s.toString());
                    int modifier = calculateAbilityModifier(score);
                    mConstitutionModifierEditText.setText(String.valueOf(modifier));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        mIntelligenceScoreEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    int score = Integer.parseInt(s.toString());
                    int modifier = calculateAbilityModifier(score);
                    mIntelligenceModifierEditText.setText(String.valueOf(modifier));
                    mArcanaModifierEditText.setText(String.valueOf(modifier));
                    mHistoryModifierEditText.setText(String.valueOf(modifier));
                    mInvestigationModifierEditText.setText(String.valueOf(modifier));
                    mNatureModifierEditText.setText(String.valueOf(modifier));
                    mReligionModifierEditText.setText(String.valueOf(modifier));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        mWisdomScoreEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    int score = Integer.parseInt(s.toString());
                    int modifier = calculateAbilityModifier(score);
                    mWisdomModifierEditText.setText(String.valueOf(modifier));
                    mAnimalHandlingModifierEditText.setText(String.valueOf(modifier));
                    mInsightModifierEditText.setText(String.valueOf(modifier));
                    mMedicineModifierEditText.setText(String.valueOf(modifier));
                    mPerceptionModifierEditText.setText(String.valueOf(modifier));
                    mSurvivalModifierEditText.setText(String.valueOf(modifier));
                    mPassivePerceptionEditText.setText(String.valueOf(10+modifier));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        mCharismaScoreEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    int score = Integer.parseInt(s.toString());
                    int modifier = calculateAbilityModifier(score);
                    mCharismaModifierEditText.setText(String.valueOf(modifier));
                    mDeceptionModifierEditText.setText(String.valueOf(modifier));
                    mIntimidationModifierEditText.setText(String.valueOf(modifier));
                    mPerformanceModifierEditText.setText(String.valueOf(modifier));
                    mPersuasionModifierEditText.setText(String.valueOf(modifier));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        mLevelEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    int level = Integer.parseInt(s.toString());
                    calculateProficiencyBonus(level);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        Button saveAsPdfButton = findViewById(R.id.save_as_pdf_button);
        saveAsPdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSheetAsPdf();
                Toast.makeText(CharacterSheet.this, "Sheet details saved as PDF", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CharacterSheet.this, PdfViewerActivity.class);
                startActivity(intent);

            }
        });


    }

    public int calculateAbilityModifier(int score) {
        int modifier = (score - 10) / 2;
        return modifier;
    }


    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void toggleProficiency(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.acrobatics_proficiency:
                if (checked) {
                    int acrobaticsScore = Integer.parseInt(mDexterityModifierEditText.getText().toString()) + proficiencyBonus;
                    mAcrobaticsModifierEditText.setText("+" + Integer.toString(acrobaticsScore));
                } else {
                    mAcrobaticsModifierEditText.setText(mDexterityModifierEditText.getText().toString());
                }
                break;
            case R.id.animal_handling_proficiency:
                if (checked) {
                    int animalHandlingScore = Integer.parseInt(mWisdomModifierEditText.getText().toString()) + proficiencyBonus;
                    mAnimalHandlingModifierEditText.setText("+" + Integer.toString(animalHandlingScore));
                } else {
                    mAnimalHandlingModifierEditText.setText(mWisdomModifierEditText.getText().toString());
                }
                break;
            case R.id.arcana_proficiency:
                if (checked) {
                    int arcanaScore = Integer.parseInt(mIntelligenceModifierEditText.getText().toString()) + proficiencyBonus;
                    mArcanaModifierEditText.setText("+" + Integer.toString(arcanaScore));
                } else {
                    mArcanaModifierEditText.setText(mIntelligenceModifierEditText.getText().toString());
                }
                break;
            case R.id.athletics_proficiency:
                if (checked) {
                    int athleticsScore = Integer.parseInt(mStrengthModifierEditText.getText().toString()) + proficiencyBonus;
                    mAthleticsModifierEditText.setText("+" + Integer.toString(athleticsScore));
                } else {
                    mAthleticsModifierEditText.setText(mStrengthModifierEditText.getText().toString());
                }
                break;
            case R.id.deception_proficiency:
                if (checked) {
                    int deceptionScore = Integer.parseInt(mCharismaModifierEditText.getText().toString()) + proficiencyBonus;
                    mDeceptionModifierEditText.setText("+" + Integer.toString(deceptionScore));
                } else {
                    mDeceptionModifierEditText.setText(mCharismaModifierEditText.getText().toString());
                }
                break;
            case R.id.history_proficiency:
                if (checked) {
                    int historyScore = Integer.parseInt(mIntelligenceModifierEditText.getText().toString()) + proficiencyBonus;
                    mHistoryModifierEditText.setText("+" + Integer.toString(historyScore));
                } else {
                    mHistoryModifierEditText.setText(mIntelligenceModifierEditText.getText().toString());
                }
                break;
            case R.id.insight_proficiency:
                if (checked) {
                    int insightScore = Integer.parseInt(mWisdomModifierEditText.getText().toString()) + proficiencyBonus;
                    mInsightModifierEditText.setText("+" + Integer.toString(insightScore));
                } else {
                    mInsightModifierEditText.setText(mWisdomModifierEditText.getText().toString());
                }
                break;
            case R.id.intimidation_proficiency:
                if (checked) {
                    int intimidationScore = Integer.parseInt(mCharismaModifierEditText.getText().toString()) + proficiencyBonus;
                    mIntimidationModifierEditText.setText("+" + Integer.toString(intimidationScore));
                } else {
                    mIntimidationModifierEditText.setText(mCharismaModifierEditText.getText().toString());
                }
                break;
            case R.id.investigation_proficiency:
                if (checked) {
                    int investigationScore = Integer.parseInt(mIntelligenceModifierEditText.getText().toString()) + proficiencyBonus;
                    mInvestigationModifierEditText.setText("+" + Integer.toString(investigationScore));
                } else {
                    mInvestigationModifierEditText.setText(mIntelligenceModifierEditText.getText().toString());
                }
                break;
            case R.id.medicine_proficiency:
                if (checked) {
                    int medicineScore = Integer.parseInt(mWisdomModifierEditText.getText().
                            toString()) + proficiencyBonus;
                    mMedicineModifierEditText.setText("+" + Integer.toString(medicineScore));
                } else {
                    mMedicineModifierEditText.setText(mWisdomModifierEditText.getText().toString());
                }
                break;
            case R.id.nature_proficiency:
                if (checked) {
                    int natureScore = Integer.parseInt(mIntelligenceModifierEditText.getText().toString()) + proficiencyBonus;
                    mNatureModifierEditText.setText("+" + Integer.toString(natureScore));
                } else {
                    mNatureModifierEditText.setText(mIntelligenceModifierEditText.getText().toString());
                }
                break;
            case R.id.perception_proficiency:
                if (checked) {
                    int perceptionScore = Integer.parseInt(mWisdomModifierEditText.getText().toString()) + proficiencyBonus;
                    mPerceptionModifierEditText.setText("+" + Integer.toString(perceptionScore));
                } else {
                    mPerceptionModifierEditText.setText(mWisdomModifierEditText.getText().toString());
                }
                break;
            case R.id.performance_proficiency:
                if (checked) {
                    int performanceScore = Integer.parseInt(mCharismaModifierEditText.getText().toString()) + proficiencyBonus;
                    mPerformanceModifierEditText.setText("+" + Integer.toString(performanceScore));
                } else {
                    mPerformanceModifierEditText.setText(mCharismaModifierEditText.getText().toString());
                }
                break;
            case R.id.persuasion_proficiency:
                if (checked) {
                    int persuasionScore = Integer.parseInt(mCharismaModifierEditText.getText().toString()) + proficiencyBonus;
                    mPersuasionModifierEditText.setText("+" + Integer.toString(persuasionScore));
                } else {
                    mPersuasionModifierEditText.setText(mCharismaModifierEditText.getText().toString());
                }
                break;
            case R.id.religion_proficiency:
                if (checked) {
                    int religionScore = Integer.parseInt(mIntelligenceModifierEditText.getText().toString()) + proficiencyBonus;
                    mReligionModifierEditText.setText("+" + Integer.toString(religionScore));
                } else {
                    mReligionModifierEditText.setText(mIntelligenceModifierEditText.getText().toString());
                }
                break;
            case R.id.sleight_of_hand_proficiency:
                if (checked) {
                    int sleightOfHandScore = Integer.parseInt(mDexterityModifierEditText.getText().toString()) + proficiencyBonus;
                    mSleightOfHandModifierEditText.setText("+" + Integer.toString(sleightOfHandScore));
                } else {
                    mSleightOfHandModifierEditText.setText(mDexterityModifierEditText.getText().toString());
                }
                break;
            case R.id.stealth_proficiency:
                if (checked) {
                    int stealthScore = Integer.parseInt(mDexterityModifierEditText.getText().toString()) + proficiencyBonus;
                    mStealthModifierEditText.setText("+" + Integer.toString(stealthScore));
                } else {
                    mStealthModifierEditText.setText(mDexterityModifierEditText.getText().toString());
                }
                break;
            case R.id.survival_proficiency:
                if (checked) {
                    int survivalScore = Integer.parseInt(mWisdomModifierEditText.getText().toString()) + proficiencyBonus;
                    mSurvivalModifierEditText.setText("+" + Integer.toString(survivalScore));
                } else {
                    mSurvivalModifierEditText.setText(mWisdomModifierEditText.getText().toString());
                }
                break;
        }
    }
    @SuppressLint("SetTextI18n")
    private void calculateModifiers() {
        int strengthScore = Integer.parseInt(String.valueOf(R.id.strength_score));
        int dexterityScore = Integer.parseInt(String.valueOf(R.id.dexterity_score));
        int constitutionScore = Integer.parseInt(String.valueOf(R.id.constitution_score));
        int intelligenceScore = Integer.parseInt(String.valueOf(R.id.intelligence_score));
        int wisdomScore = Integer.parseInt(String.valueOf(R.id.wisdom_score));
        int charismaScore = Integer.parseInt(String.valueOf(R.id.charisma_score));
        int strengthModifier = (strengthScore - 10) / 2;
        int dexterityModifier = (dexterityScore - 10) / 2;
        int constitutionModifier = (constitutionScore - 10) / 2;
        int intelligenceModifier = (intelligenceScore - 10) / 2;
        int wisdomModifier = (wisdomScore - 10) / 2;
        int charismaModifier = (charismaScore - 10) / 2;

        mStrengthModifierEditText.setText(Integer.toString(strengthModifier));
        mDexterityModifierEditText.setText(Integer.toString(dexterityModifier));
        mConstitutionModifierEditText.setText(Integer.toString(constitutionModifier));
        mIntelligenceModifierEditText.setText(Integer.toString(intelligenceModifier));
        mWisdomModifierEditText.setText(Integer.toString(wisdomModifier));
        mCharismaModifierEditText.setText(Integer.toString(charismaModifier));

    }


    private void calculateProficiencyBonus(int level) {
        switch (level) {
            case 1:
            case 2:
            case 3:
            case 4:
                proficiencyBonus = 2;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                proficiencyBonus = 3;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                proficiencyBonus = 4;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                proficiencyBonus = 5;
                break;
            default:
                proficiencyBonus = 6;
                break;
        }
    }

    private void calculateAbilityScores() {
        calculateModifiers();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("level", level);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        level = savedInstanceState.getInt("level");
        mLevelEditText.setText(Integer.toString(level));
        calculateProficiencyBonus(level);
        calculateAbilityScores();
    }

    private void resetAbilityScores() {
        mLevelEditText.setText("");
        mStrengthScoreEditText.setText("");
        mDexterityScoreEditText.setText("");
        mConstitutionScoreEditText.setText("");
        mIntelligenceScoreEditText.setText("");
        mWisdomScoreEditText.setText("");
        mCharismaScoreEditText.setText("");
        mStrengthModifierEditText.setText("");
        mDexterityModifierEditText.setText("");
        mConstitutionModifierEditText.setText("");
        mIntelligenceModifierEditText.setText("");
        mWisdomModifierEditText.setText("");
        mCharismaModifierEditText.setText("");
        mPassivePerceptionEditText.setText("");
        mInitiative.setText("");
        mArmorClass.setText("");

    }


        public void saveSheetAsPdf() {
            PdfDocument document = new PdfDocument();
            // Create a page
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(595, 842, 1).create();
            PdfDocument.Page page = document.startPage(pageInfo);

            // Create a canvas for drawing
            Canvas canvas = page.getCanvas();

            // Add sheet details to the canvas
            addSheetDetailsToCanvas(canvas);

            // Finish the page
            document.finishPage(page);

            // Save the document
            File file = new File(getExternalFilesDir(null), "sheet_details.pdf");
            try {
                document.writeTo(new FileOutputStream(file));
                Toast.makeText(this, "PDF saved successfully", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed to save PDF", Toast.LENGTH_SHORT).show();
            }

            // Close the document
            document.close();
        }

    private void addSheetDetailsToCanvas(Canvas canvas) {
        // Create a Paint object for drawing text
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);

        // Set the starting position for adding text
        float x = 50;
        float y = 50;

        // Add sheet details to the canvas
        canvas.drawText("Name:" + mCharacterName.getText().toString() , x, y, paint);
        y += 30;
        canvas.drawText("Class:" + mClass.getText().toString() , x, y, paint);
        y += 30;
        canvas.drawText("Level:" + mLevelEditText.getText().toString() , x, y, paint);
        y += 30;
        canvas.drawText("Background:" + mCharacterBackground.getText().toString() , x, y, paint);
        y += 30;
        canvas.drawText("Armor Class:" + mArmorClass.getText().toString() , x, y, paint);
        y += 30;
        canvas.drawText("Initiative:" + mInitiative.getText().toString() , x, y, paint);
        y += 30;
        canvas.drawText("Passive perception:" + mPassivePerceptionEditText.getText().toString() , x, y, paint);
        y += 30;
        canvas.drawText("Strength Score: " + mStrengthScoreEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Dexterity Score: " + mDexterityScoreEditText.getText().toString(), x, y, paint);
        y+=30;
        canvas.drawText("Constitution Score: " + mConstitutionScoreEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Intelligence Score: " + mIntelligenceScoreEditText.getText().toString(), x, y, paint);
        y+= 30;
        canvas.drawText("Wisdom score:" + mWisdomScoreEditText.getText().toString() , x, y, paint);
        y += 30;
        canvas.drawText("<-------- Skills -------->", x, y, paint);
        y += 30;
        canvas.drawText("Acrobatics Score: " + mAcrobaticsModifierEditText.getText().toString(), x, y, paint);
        y+=30;
        canvas.drawText("Animal Handling Score: " + mAnimalHandlingModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Arcana Score: " + mArcanaModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Athletics Score: " + mAthleticsModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Deception Score: " + mDeceptionModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("History Score: " + mHistoryModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Performance Score: " + mPerformanceModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Perception Score: " + mPerceptionModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Survival Score: " + mSurvivalModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Sleight of Hand Score: " + mSleightOfHandModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Insight Score: " + mInsightModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Intimidation Score: " + mIntimidationModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Investigation Score: " + mInvestigationModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Medicine Score: " + mMedicineModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Nature Score: " + mNatureModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Persuasion Score: " + mPersuasionModifierEditText.getText().toString(), x, y, paint);
        y += 30;
        canvas.drawText("Religion Score: " + mReligionModifierEditText.getText().toString(), x, y, paint);

    }


}










