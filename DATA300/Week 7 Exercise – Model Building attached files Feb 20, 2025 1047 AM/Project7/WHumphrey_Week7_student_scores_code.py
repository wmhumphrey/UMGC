import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.metrics import r2_score, mean_squared_error
from sklearn.model_selection import train_test_split
from sklearn import metrics

# imports dataset from CSV file students_scores
student_scores = pd.read_csv('student_scores.csv')

# prints first five rows of data
print(student_scores.head())

# assigns independent variable to hours
X_stu = student_scores[['Hours']]
# assigns dependent variable to scores
y_stu = student_scores['Scores']

# scatter plot to visualize the relationship between Hours Studied and Scores
plt.figure(figsize=(12,6))
plt.scatter(X_stu, y_stu, alpha=0.5, color='blue')
plt.xlabel('Hours Studied')
plt.ylabel('Scores')
plt.title('Hours Studied vs Student Scores')
plt.ticklabel_format(axis="y", style="plain")
plt.show()

# splits data into training and testing sets using 80% for training and 20% for testing
# Ensures model is learning real data patterns
X_train_stu, X_test_stu, y_train_stu, y_test_stu = train_test_split(
    X_stu, y_stu, test_size=0.2, random_state=0
)

# creates linear regression model
# a way to find a pattern in data
lin_reg_stu = LinearRegression()

# trains the model using training data
lin_reg_stu.fit(X_train_stu, y_train_stu)

# makes prediction on test data
y_pred_stu = lin_reg_stu.predict(X_test_stu)

# prints values to assists the models performance
# average absolute difference between actual and predicted student scores
# average amount models prediction was off in points
print('Mean Absolute Error:', metrics.mean_absolute_error(y_test_stu, y_pred_stu))

# squared differences between actual and predicted scores
print('Mean Squared Error:', metrics.mean_squared_error(y_test_stu, y_pred_stu))

# converts error measure back to same unit
print('Root Mean Squared Error:', np.sqrt(metrics.mean_squared_error(y_test_stu, y_pred_stu)))

# Measures how well the model explains student scores
# ranges [0,1] closer to 1 the better match the model is
print('R2 Score:', r2_score(y_test_stu, y_pred_stu))

#Expected test score if student studies for zero hours
print('Intercept:', lin_reg_stu.intercept_)

# How much a students score will increase for every additional hour of studying
print('Coefficient of line:', lin_reg_stu.coef_)

# creates index numbers fir each test case
c_stu = [i for i in range(1, len(y_test_stu) + 1, 1)]

# Graph to compare actual vs predicted scores
plt.figure(figsize=(12,6))
plt.plot(c_stu, y_test_stu, color='r', linestyle='-')
plt.plot(c_stu, y_pred_stu, color='b', linestyle='-')
plt.xlabel('Actual Scores')
plt.ylabel('Predicted Scores')
plt.title('Prediction')
plt.legend(['Actual Scores', 'Predicted Scores'])
plt.ticklabel_format(axis="y", style="plain")
plt.show()

# Graph to compare actual vs predicted errors for scores
plt.figure(figsize=(12,6))
plt.plot(c_stu, y_test_stu - y_pred_stu, color='green', linestyle='-')
plt.xlabel('Actual Score')
plt.ylabel('Error')
plt.title('Error')
plt.ticklabel_format(axis="y", style="plain")
plt.show()
