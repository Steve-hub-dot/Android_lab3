package hu.bme.aut.android.composebasics.feature.register

import NormalTextField
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.composebasics.R
import hu.bme.aut.android.composebasics.ui.common.BottomTextButton
import hu.bme.aut.android.composebasics.ui.common.PasswordTextField

@ExperimentalMaterial3Api
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onRegisterClick: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    var usernameValue by remember { mutableStateOf("") }
    var isUsernameError by remember { mutableStateOf(false) }

    var passwordValue by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }

    var confirmPasswordValue by remember { mutableStateOf("") }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordError by remember { mutableStateOf(false) }

    val (selectedGender, onSelected) = remember { mutableStateOf(Gender.values()[0]) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            NormalTextField(
                value = usernameValue,
                label = stringResource(id = R.string.textfield_label_username),
                onValueChange = { newValue ->
                    usernameValue = newValue
                    isUsernameError = false
                },
                isError = isUsernameError,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                },
                trailingIcon = { },
                onDone = { }
            )
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextField(
                value = passwordValue,
                label = stringResource(id = R.string.textfield_label_password),
                onValueChange = { newValue ->
                    passwordValue = newValue
                    isPasswordError = false
                },
                isError = isPasswordError,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Key,
                        contentDescription = null
                    )
                },
                isVisible = isPasswordVisible,
                onVisibilityChanged = { isPasswordVisible = !isPasswordVisible },
                onDone = { }
            )
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextField(
                value = confirmPasswordValue,
                label = stringResource(id = R.string.textfield_label_confirmpassword),
                onValueChange = { newValue ->
                    confirmPasswordValue = newValue
                    isConfirmPasswordError = false
                },
                isError = isConfirmPasswordError,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Key,
                        contentDescription = null
                    )
                },
                isVisible = isConfirmPasswordVisible,
                onVisibilityChanged = { isConfirmPasswordVisible = !isConfirmPasswordVisible },
                onDone = { }
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.text_select_a_gender),
                color = MaterialTheme.colorScheme.onBackground
            )
            Gender.values().forEach { gender ->
                Row(
                    Modifier
                        .height(56.dp)
                        .width(TextFieldDefaults.MinWidth)
                        .selectable(
                            selected = (gender == selectedGender),
                            onClick = { onSelected(gender) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    RadioButton(
                        selected = (gender == selectedGender),
                        onClick = null
                    )
                    Text(
                        text = stringResource(id = gender.nameId),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
            Button(
                onClick = {
                    if (usernameValue.isEmpty()) {
                        isUsernameError = true
                    } else if (passwordValue.isEmpty() || confirmPasswordValue.isEmpty()) {
                        isConfirmPasswordError = true
                    } else {
                        onRegisterClick(usernameValue)
                    }
                },
                modifier = Modifier.width(TextFieldDefaults.MinWidth)
            ) {
                Text(text = stringResource(id = R.string.button_label_register))
            }
        }
        BottomTextButton(
            onClick = onLoginClick,
            label = stringResource(id = R.string.button_label_already_have_account),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun RegisterScreen_Preview() {
    RegisterScreen(
        onLoginClick = { },
        onRegisterClick = { }
    )
}