package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment.Payment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.AddCartRequest;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.Payment.DoAddToCartPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentAddCartBinding;
import com.zcw.togglebutton.ToggleButton;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class AddCartFragment extends Fragment implements DoAddToCartPresenter.DoAddToCartView {
    FragmentAddCartBinding binding;
    private View view;
    NavController navController;
    String CardNumber, ExpMonth, ExpYear, CVC, Setasdefult = "No", FuturePayment = "No", Exp;
    DoAddToCartPresenter doAddToCartPresenter;

    private static final int CARD_DATE_TOTAL_SYMBOLS = 5; // size of pattern MM/YY
    private static final int CARD_DATE_TOTAL_DIGITS = 4; // max numbers of digits in pattern: MM + YY
    private static final int CARD_DATE_DIVIDER_MODULO = 3; // means divider position is every 3rd symbol beginning with 1
    private static final int CARD_DATE_DIVIDER_POSITION = CARD_DATE_DIVIDER_MODULO - 1; // means divider position is every 2nd symbol beginning with 0
    private static final char CARD_DATE_DIVIDER = '/';
    String key, id;

    public AddCartFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_cart, container, false);
        view = binding.getRoot();
        doAddToCartPresenter = new DoAddToCartPresenter(this);




     /*   Bundle bundle = new Bundle();
        bundle.putString("Key","Edit");
        bundle.putString("cardNumber",repo.getData().getCards().getData().get(pos).getCardNumber());
        bundle.putString("ExpDate",repo.getData().getCards().getData().get(pos).getExpMonth()+"/"+lasttwochar);
        bundle.putString("CVV",repo.getData().getCards().getData().get(pos).getCvv());
        bundle.putString("defualt",repo.getData().getCards().getData().get(pos).getSetAsDefault());
        bundle.putString("future", repo.getData().getCards().getData().get(pos).getFuturePayment());
        bundle.putString("id",String.valueOf(repo.getData().getCards().getData().get(pos).getId()));
*/


        if (getArguments().getString("Key") != null) {
            key = getArguments().getString("Key");

            if (key.equalsIgnoreCase("Edit")) {


                id = getArguments().getString("id");
                binding.cardNumberET.setText(getArguments().getString("cardNumber"));
                binding.ExpDateET.setText(getArguments().getString("ExpDate"));
                binding.CVVET.setText(getArguments().getString("CVV"));
                if (getArguments().getString("defualt").equalsIgnoreCase("Yes")) {
                    binding.defualtcardTB.setToggleOn(true);
                    Setasdefult = "Yes";
                }else {
                    Setasdefult = "No";
                }
                if (getArguments().getString("future").equalsIgnoreCase("Yes")) {
                    binding.futureTB.setToggleOn(true);
                    FuturePayment = "Yes";

                }else {
                    FuturePayment = "No";
                }

            }
            //presenter.GetAddAddressById(getContext(), getArguments().getString("id"));

        }


        binding.AddCardTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AddtoCart();

            }
        });
        binding.ExpDateET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!isInputCorrect(s, CARD_DATE_TOTAL_SYMBOLS, CARD_DATE_DIVIDER_MODULO, CARD_DATE_DIVIDER)) {

                    s.replace(0, s.length(), concatString(getDigitArray(s, CARD_DATE_TOTAL_DIGITS), CARD_DATE_DIVIDER_POSITION, CARD_DATE_DIVIDER));
                }
            }
        });


        binding.defualtcardTB.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {


                if (on == true) {
                    Setasdefult = "Yes";

                } else {
                    Setasdefult = "No";

                }
            }
        });

        binding.futureTB.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on == true) {
                    FuturePayment = "Yes";

                } else {
                    FuturePayment = "No";

                }
            }
        });

        return binding.getRoot();
    }

    private void AddtoCart() {




        CardNumber = binding.cardNumberET.getText().toString().trim();
        CVC = binding.CVVET.getText().toString().trim();


        Exp = binding.ExpDateET.getText().toString().trim();

        if (CardNumber.length() != 16) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Enter Card Number")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (Exp.length() != 5) {

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Enter Exp. Date")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();

        } else if (CVC.length() != 3) {


            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Enter CVV ")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else {


            String[] parts = Exp.split("/");
            ExpMonth = parts[0]; // 004
            ExpYear = parts[1]; // 034556


            if (Integer.valueOf(ExpYear) >= 21 && Integer.valueOf(ExpMonth) <= 31) {

                if (key.equalsIgnoreCase("Edit")) {

                    Toast.makeText(getContext(), Setasdefult+"\n"+FuturePayment, Toast.LENGTH_SHORT).show();
                    AddCartRequest addCartRequest = new AddCartRequest(CardNumber, ExpMonth, 20+ExpYear, CVC, Setasdefult, FuturePayment, "PATCH");
                    doAddToCartPresenter.DoUpdateCart(getContext(), addCartRequest, id);
                } else {
                    AddCartRequest addCartRequest = new AddCartRequest(CardNumber, ExpMonth, 20 + ExpYear, CVC, Setasdefult, FuturePayment);
                    doAddToCartPresenter.DoAddToCartt(getContext(), addCartRequest);
                }


            } else {
                Snacky.builder()
                        .setActivity(getActivity())
                        .setText("Expiration date for credit card increect")
                        .setTextColor(getResources().getColor(R.color.white))
                        .warning()
                        .show();

            }

        }


    }

    @Override
    public void onAddtoCartError(String message) {
        if (message.equalsIgnoreCase("422")) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Enter a valid Card Details")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else {


            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(message)
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        }
    }

    @Override
    public void onAddtoCartSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            navController.navigate(R.id.paymentsFragment);
        }

    }

    @Override
    public void OnUpdateCartSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Card Updated Successfully. ")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        }
    }

    @Override
    public void showHideProgress(boolean isShow) {

        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onAddtoCartFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    private boolean isInputCorrect(Editable s, int size, int dividerPosition, char divider) {
        boolean isCorrect = s.length() <= size;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (i + 1) % dividerPosition == 0) {
                isCorrect &= divider == s.charAt(i);
            } else {
                isCorrect &= Character.isDigit(s.charAt(i));
            }
        }
        return isCorrect;
    }

    private String concatString(char[] digits, int dividerPosition, char divider) {
        final StringBuilder formatted = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) {
                formatted.append(digits[i]);
                if ((i > 0) && (i < (digits.length - 1)) && (((i + 1) % dividerPosition) == 0)) {
                    formatted.append(divider);
                }
            }
        }

        return formatted.toString();
    }

    private char[] getDigitArray(final Editable s, final int size) {
        char[] digits = new char[size];
        int index = 0;
        for (int i = 0; i < s.length() && index < size; i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                digits[index] = current;
                index++;
            }
        }
        return digits;
    }
}