import numpy as np
import pandas as pd
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import GridSearchCV
import joblib
from skl2onnx import convert_sklearn
from skl2onnx.common.data_types import FloatTensorType
import onnx

# Load dataset
iris = pd.read_csv('./iris.csv')

# Drop the 'id' column
iris.drop('id', axis=1, inplace=True)

# Define features and target variable
X = iris[['sepal_len', 'sepal_wd', 'petal_len', 'petal_wd']]
y = iris['species']

# Create a KNN model
knn = KNeighborsClassifier()

# Create a dictionary of all values we want to test for n_neighbors
param_grid = {'n_neighbors': np.arange(2, 15)}

# Use GridSearchCV to test all values for n_neighbors
knn_gscv = GridSearchCV(knn, param_grid, cv=4)

# Fit model to the entire dataset
knn_gscv.fit(X, y)

# Retrieve the best model with the best parameters
best_knn = knn_gscv.best_estimator_

# Convert the model to ONNX format
initial_type = [('float_input', FloatTensorType([None, 4]))]
onnx_model = convert_sklearn(best_knn, initial_types=initial_type)

# Save the ONNX model to a file
with open('iris_knn_model.onnx', 'wb') as f:
    f.write(onnx_model.SerializeToString())

print("Model training complete and saved as 'iris_knn_model.onnx'")
