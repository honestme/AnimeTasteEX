/*
 * Copyright 2014 Chris Banes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.honestme.animetasteex.login;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.honestme.animetasteex.R;


public class LoginFragment extends Fragment implements LoginPresenter.LoginUi, View.OnClickListener,
        TextView.OnEditorActionListener, RadioGroup.OnCheckedChangeListener {

    private static final String KEY_NEW_ACCOUNT = "new_account";

    private LoginPresenter.LoginUiCallbacks mCallbacks;

    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginButton;

    private RadioGroup mTypeRadioGroup;
    private RadioButton mLoginRadioButton, mCreateRadioButton;
    private AutoCompleteTextView mPhoneAutoComplete;

    public static LoginFragment create() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mUsername = (EditText) view.findViewById(R.id.edit_login);
        mUsername.setOnEditorActionListener(this);
        mPassword = (EditText) view.findViewById(R.id.edit_password);
        mPassword.setOnEditorActionListener(this);

        mLoginButton = (Button) view.findViewById(R.id.btn_submit);
        mLoginButton.setOnClickListener(this);

        mTypeRadioGroup = (RadioGroup) view.findViewById(R.id.rg_type);
        mTypeRadioGroup.setOnCheckedChangeListener(this);

        mPhoneAutoComplete = (AutoCompleteTextView) view.findViewById(R.id.login_phone);
        mPhoneAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mPhoneAutoComplete.showDropDown();
            }
        });

        mLoginRadioButton = (RadioButton) view.findViewById(R.id.rb_login);
        mCreateRadioButton = (RadioButton) view.findViewById(R.id.rb_create);

        mLoginRadioButton.setChecked(true);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getController().attachUi(this);
    }

    @Override
    public void onPause() {
        getController().detachUi(this);
        super.onPause();
    }

    @Override
    public void showLoadingProgress(boolean visible) {
        getActivity().setProgressBarIndeterminateVisibility(visible);
    }





    @Override
    public void showError(LoginPresenter.Error error) {
        switch (error) {
            case BAD_AUTH:
                mPassword.setError(getString(R.string.login_login_failed));
                break;
            case BAD_REGISTER:
                mUsername.setError(getString(R.string.login_register_failed));
                break;
        }
    }





    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                submit();
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
        if (textView == mPassword) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_DONE:
                    submit();
                    return true;
            }
        }
        return false;
    }

    private void submit() {
        mPassword.setError(null);

        if (mCallbacks != null) {
            final String username = mUsername.getText().toString().trim();
            if (!mCallbacks.isUserEmpty(username)) {
                mUsername.setError(getString(R.string.login_username_empty));
                return;
            }
            mUsername.setError(null);

            final String password = mPassword.getText().toString().trim();
            if (!mCallbacks.isPasswordEmpty(password)) {
                mPassword.setError(getString(R.string.login_password_empty));
                return;
            }
            mPassword.setError(null);

            switch (mTypeRadioGroup.getCheckedRadioButtonId()) {
                case R.id.rb_login:
                    mCallbacks.login(username, password);
                    break;
                case R.id.rb_create:
                    final String phone = mPhoneAutoComplete.getText().toString().trim();
                    if (!mCallbacks.isPhoneEmpty(phone)) {
                        mPhoneAutoComplete.setError(getString(R.string.login_phone_invalid));
                        return;
                    }
                    mPhoneAutoComplete.setError(null);

                    mCallbacks.createAccount(username, password, phone);
                    break;
            }
        }
    }

    LoginPresenter getController() {
        return new LoginPresenter();
    }



    @Override
    public void setCallBack(LoginPresenter.LoginUiCallbacks callbacks) {
        mCallbacks = callbacks;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_login:
                mLoginButton.setText(R.string.login_login);
                mPhoneAutoComplete.setVisibility(View.GONE);
                break;
            case R.id.rb_create:
                mLoginButton.setText(R.string.login_register);
                mPhoneAutoComplete.setVisibility(View.VISIBLE);

                if (mPhoneAutoComplete.getAdapter() == null) {
                    final Set<String> phoneSet = new HashSet<>();
                    for (Account account : AccountManager.get(getActivity()).getAccounts()) {
                        if (Patterns.EMAIL_ADDRESS.matcher(account.name).matches()) {
                            phoneSet.add(account.name);
                        }
                    }
                    List<String> emails = new ArrayList<>(phoneSet);
                    mPhoneAutoComplete.setAdapter(new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_spinner_dropdown_item, emails));
                }
                break;
        }

    }
}
